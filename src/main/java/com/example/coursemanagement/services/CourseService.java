package com.example.coursemanagement.services;

import com.example.coursemanagement.models.Course;
import com.example.coursemanagement.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.create(course);
    }

    public Course updateCourse(Long id, Course course) {
        return courseRepository.update(id, course);
    }

    public Course deleteCourseById(Long id) {
        return courseRepository.deleteById(id);
    }
}