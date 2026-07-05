package com.example.coursemanagement.repositories;

import com.example.coursemanagement.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course(1L, "Spring Boot Basics", "Active", 1L));
        courses.add(new Course(2L, "Advanced Java", "Active", 2L));
    }

    public List<Course> findAll() {
        return courses;
    }
}