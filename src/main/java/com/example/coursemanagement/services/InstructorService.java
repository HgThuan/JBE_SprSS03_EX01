package com.example.coursemanagement.services;

import com.example.coursemanagement.dto.InstructorDetail;
import com.example.coursemanagement.exceptions.ResourceNotFoundException;
import com.example.coursemanagement.models.Course;
import com.example.coursemanagement.models.Enrollment;
import com.example.coursemanagement.models.Instructor;
import com.example.coursemanagement.repositories.EnrollmentRepository;
import com.example.coursemanagement.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final CourseService courseService;
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository,
                             CourseService courseService,
                             EnrollmentRepository enrollmentRepository) {
        this.instructorRepository = instructorRepository;
        this.courseService = courseService;
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.create(instructor);
    }

    public Instructor updateInstructor(Long id, Instructor instructor) {
        return instructorRepository.update(id, instructor);
    }

    public Instructor deleteInstructorById(Long id) {
        return instructorRepository.deleteById(id);
    }

    public List<InstructorDetail> getInstructorDetails() {
        List<Instructor> instructors = instructorRepository.findAll();
        List<Course> allCourses = courseService.getAllCourses();
        List<Enrollment> allEnrollments = enrollmentRepository.findAll();

        return instructors.stream().map(instructor -> {
            List<Course> validCourses = allCourses.stream()
                    .filter(course -> course.getInstructorId().equals(instructor.getId()))
                    .filter(course -> "Active".equalsIgnoreCase(course.getStatus()))
                    .filter(course -> allEnrollments.stream()
                            .anyMatch(e -> e.getCourseId().equals(course.getId())))
                    .collect(Collectors.toList());
            
            return new InstructorDetail(instructor, validCourses);
        }).collect(Collectors.toList());
    }
}