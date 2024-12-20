package com.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.DTO.LoginResponse;
import com.university.model.StudentRegistration;
import com.university.repository.StudentRegistrationRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private StudentRegistrationRepository studentRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody StudentRegistration student) {

        if (studentRepository.findByEmail(student.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new LoginResponse("error", null, "User already exists"));
        }


       // student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setPassword(student.getPassword());
        StudentRegistration savedStudent = studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new LoginResponse("success", savedStudent.getId(), "Registration successful"));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody StudentRegistration student) {
      
        StudentRegistration existingStudent = studentRepository.findByEmail(student.getEmail());

        if (existingStudent != null) {

            if (student.getPassword().equalsIgnoreCase(existingStudent.getPassword())) {
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
