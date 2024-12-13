package com.university.controller;


import com.university.model.StudentRegistration;
import com.university.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Register a student
    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody StudentRegistration student) {
        try {
            registrationService.registerStudent(student);
            return ResponseEntity.ok("Registration successful!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<StudentRegistration>> getAllStudents() {
        List<StudentRegistration> students = registrationService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Update student status (Approve/Reject)
    @PutMapping("/{id}")
    public ResponseEntity<StudentRegistration> updateStudentStatus(
            @PathVariable Long id, @RequestBody StudentRegistration updatedStudent) {
        Optional<StudentRegistration> existingStudentOpt = registrationService.getStudentById(id);
        if (existingStudentOpt.isPresent()) {
            StudentRegistration existingStudent = existingStudentOpt.get();
            existingStudent.setStatus(updatedStudent.getStatus());  // Update status to "Approved" or "Rejected"
            registrationService.saveStudent(existingStudent);  // Save the updated student
            return ResponseEntity.ok(existingStudent);
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if student not found
        }
    }
}

