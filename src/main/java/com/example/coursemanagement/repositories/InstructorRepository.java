package com.example.coursemanagement.repositories;

import com.example.coursemanagement.exceptions.ResourceNotFoundException;
import com.example.coursemanagement.models.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InstructorRepository {
    private final List<Instructor> instructors = new ArrayList<>();
    private Long nextId = 3L; // Since we start with 1L and 2L

    public InstructorRepository() {
        instructors.add(new Instructor(1L, "Alice", "alice@example.com"));
        instructors.add(new Instructor(2L, "Bob", "bob@example.com"));
    }

    public List<Instructor> findAll() {
        return instructors;
    }

    public Optional<Instructor> findById(Long id) {
        return instructors.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Instructor create(Instructor instructor) {
        instructor.setId(nextId++);
        instructors.add(instructor);
        return instructor;
    }

    public Instructor update(Long id, Instructor updatedInstructor) {
        Instructor instructor = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));
        
        instructor.setName(updatedInstructor.getName());
        instructor.setEmail(updatedInstructor.getEmail());
        return instructor;
    }

    public Instructor deleteById(Long id) {
        Instructor instructor = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));
        
        instructors.remove(instructor);
        return instructor;
    }
}