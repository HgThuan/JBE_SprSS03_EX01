package com.example.coursemanagement.repositories;

import com.example.coursemanagement.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepository() {
        enrollments.add(new Enrollment(1L, "John Doe", 1L));
        enrollments.add(new Enrollment(2L, "Jane Smith", 2L));
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }
}