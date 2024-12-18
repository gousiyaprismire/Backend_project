package com.university.controller;


import com.university.model.StudentRegistration;
import com.university.service.EmailService;
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
    
    @Autowired
    private EmailService emailService;

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
    public ResponseEntity<?> updateStudentStatus(@PathVariable Long id, @RequestBody StudentRegistration updatedStudent) {
    	//System.out.println("id :"+id);
        Optional<StudentRegistration> existingStudentOpt = registrationService.getStudentById(id);
        
        if (existingStudentOpt.isPresent()) {
        	//System.out.println("id 111111:");
            StudentRegistration existingStudent = existingStudentOpt.get();
           // System.out.println("id 2222:");
            // Update student status
            existingStudent.setStatus(updatedStudent.getStatus());
            registrationService.saveStudent(existingStudent);
            System.out.println("id 33333:");
            // Send email only if the status is "Approved"
            if ("Approved".equalsIgnoreCase(updatedStudent.getStatus())) {
                emailService.sendApprovalEmail(existingStudent.getEmail(), existingStudent.getFullname());
            }
            System.out.println("id 4444:");
            return ResponseEntity.ok(existingStudent);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if student not found
        }
    }
}

