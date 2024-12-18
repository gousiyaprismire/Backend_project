package com.university.controller;

import com.university.DTO.LoginResponse;
import com.university.model.StudentRegistration;
import com.university.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private StudentRegistrationRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody StudentRegistration student) {

        if (studentRepository.findByEmail(student.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new LoginResponse("error", null, "User already exists"));
        }


        student.setPassword(passwordEncoder.encode(student.getPassword()));
        StudentRegistration savedStudent = studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new LoginResponse("success", savedStudent.getId(), "Registration successful"));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody StudentRegistration student) {
      
        StudentRegistration existingStudent = studentRepository.findByEmail(student.getEmail());

        if (existingStudent != null) {

            if (passwordEncoder.matches(student.getPassword(), existingStudent.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new LoginResponse("success", existingStudent.getId(), "Login successful"));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new LoginResponse("error", null, "Invalid password"));
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new LoginResponse("error", null, "User not found"));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        StudentRegistration student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new LoginResponse("error", null, "Student not found"));
        }
    }
}
