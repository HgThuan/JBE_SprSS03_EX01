package com.example.coursemanagement.repositories;

import com.example.coursemanagement.exceptions.ResourceNotFoundException;
import com.example.coursemanagement.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();
    private Long nextId = 3L;

    public EnrollmentRepository() {
        enrollments.add(new Enrollment(1L, "John Doe", 1L));
        enrollments.add(new Enrollment(2L, "Jane Smith", 2L));
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }

    public Optional<Enrollment> findById(Long id) {
        return enrollments.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Enrollment create(Enrollment enrollment) {
        enrollment.setId(nextId++);
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(Long id, Enrollment updatedEnrollment) {
        Enrollment enrollment = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + id));
        
        enrollment.setStudentName(updatedEnrollment.getStudentName());
        enrollment.setCourseId(updatedEnrollment.getCourseId());
        return enrollment;
    }

    public Enrollment deleteById(Long id) {
        Enrollment enrollment = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + id));
        
        enrollments.remove(enrollment);
        return enrollment;
    }
}