package com.university.controller;

import lombok.AllArgsConstructor;
import com.university.DTO.LoginResponse;
import com.university.model.StudentRegistration;
import com.university.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class LoginController {

    @Autowired
    private StudentRegistrationRepository studentRepository;

   
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody StudentRegistration student) {
        System.out.println("Login attempt for student: " + student.getEmail());

        StudentRegistration existingStudent = studentRepository.findByEmail(student.getEmail());

        if (existingStudent != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new LoginResponse("success", existingStudent.getId(), "success"));
        }


        studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new LoginResponse("success", student.getId(), "success"));
    }


    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getStudentById(@RequestParam Long studentId) {
        StudentRegistration existingStudent = studentRepository.findById(studentId).orElse(null);

        if (existingStudent != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new LoginResponse("success", existingStudent.getId(), "success"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new LoginResponse("error", null, "Student not found"));
    }
}
