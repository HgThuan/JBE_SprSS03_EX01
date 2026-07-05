import os

base_dir = "/Users/hoangthuan/HW_JB-IOC/Spr/Spr_SS03/EX01/src/main/java/com/example/coursemanagement"

files = {
    "models/Instructor.java": """package com.example.coursemanagement.models;

public class Instructor {
    private Long id;
    private String name;
    private String email;

    public Instructor() {}

    public Instructor(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}""",
    "models/Course.java": """package com.example.coursemanagement.models;

public class Course {
    private Long id;
    private String title;
    private String status;
    private Long instructorId;

    public Course() {}

    public Course(Long id, String title, String status, Long instructorId) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.instructorId = instructorId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getInstructorId() { return instructorId; }
    public void setInstructorId(Long instructorId) { this.instructorId = instructorId; }
}""",
    "models/Enrollment.java": """package com.example.coursemanagement.models;

public class Enrollment {
    private Long id;
    private String studentName;
    private Long courseId;

    public Enrollment() {}

    public Enrollment(Long id, String studentName, Long courseId) {
        this.id = id;
        this.studentName = studentName;
        this.courseId = courseId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
}""",
    "repositories/InstructorRepository.java": """package com.example.coursemanagement.repositories;

import com.example.coursemanagement.models.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepository {
    private final List<Instructor> instructors = new ArrayList<>();

    public InstructorRepository() {
        instructors.add(new Instructor(1L, "Alice", "alice@example.com"));
        instructors.add(new Instructor(2L, "Bob", "bob@example.com"));
    }

    public List<Instructor> findAll() {
        return instructors;
    }
}""",
    "repositories/CourseRepository.java": """package com.example.coursemanagement.repositories;

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
}""",
    "repositories/EnrollmentRepository.java": """package com.example.coursemanagement.repositories;

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
}""",
    "services/InstructorService.java": """package com.example.coursemanagement.services;

import com.example.coursemanagement.models.Instructor;
import com.example.coursemanagement.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }
}""",
    "services/CourseService.java": """package com.example.coursemanagement.services;

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
}""",
    "services/EnrollmentService.java": """package com.example.coursemanagement.services;

import com.example.coursemanagement.models.Enrollment;
import com.example.coursemanagement.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}""",
    "controllers/InstructorController.java": """package com.example.coursemanagement.controllers;

import com.example.coursemanagement.models.Instructor;
import com.example.coursemanagement.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> getInstructors() {
        return instructorService.getAllInstructors();
    }
}""",
    "controllers/CourseController.java": """package com.example.coursemanagement.controllers;

import com.example.coursemanagement.models.Course;
import com.example.coursemanagement.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }
}""",
    "controllers/EnrollmentController.java": """package com.example.coursemanagement.controllers;

import com.example.coursemanagement.models.Enrollment;
import com.example.coursemanagement.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public List<Enrollment> getEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
}"""
}

for rel_path, content in files.items():
    full_path = os.path.join(base_dir, rel_path)
    os.makedirs(os.path.dirname(full_path), exist_ok=True)
    with open(full_path, "w") as f:
        f.write(content)
