package com.example.coursemanagement.repositories;

import com.example.coursemanagement.exceptions.ResourceNotFoundException;
import com.example.coursemanagement.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();
    private Long nextId = 3L;

    public CourseRepository() {
        courses.add(new Course(1L, "Spring Boot Basics", "Active", 1L));
        courses.add(new Course(2L, "Advanced Java", "Active", 2L));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Optional<Course> findById(Long id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Course create(Course course) {
        course.setId(nextId++);
        courses.add(course);
        return course;
    }

    public Course update(Long id, Course updatedCourse) {
        Course course = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        
        course.setTitle(updatedCourse.getTitle());
        course.setStatus(updatedCourse.getStatus());
        course.setInstructorId(updatedCourse.getInstructorId());
        return course;
    }

    public Course deleteById(Long id) {
        Course course = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        
        courses.remove(course);
        return course;
    }
}