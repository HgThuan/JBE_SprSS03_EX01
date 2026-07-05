package com.example.coursemanagement.dto;

import com.example.coursemanagement.models.Course;
import com.example.coursemanagement.models.Instructor;

import java.util.List;

public class InstructorDetail {
    private Instructor instructor;
    private List<Course> activeCoursesWithEnrollments;

    public InstructorDetail() {
    }

    public InstructorDetail(Instructor instructor, List<Course> activeCoursesWithEnrollments) {
        this.instructor = instructor;
        this.activeCoursesWithEnrollments = activeCoursesWithEnrollments;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Course> getActiveCoursesWithEnrollments() {
        return activeCoursesWithEnrollments;
    }

    public void setActiveCoursesWithEnrollments(List<Course> activeCoursesWithEnrollments) {
        this.activeCoursesWithEnrollments = activeCoursesWithEnrollments;
    }
}
