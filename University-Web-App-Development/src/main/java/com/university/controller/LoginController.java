package com.university.controller;

import com.university.DTO.LoginResponse;
import com.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/students")
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Admin.Student student) {
        System.out.println("Login attempt for student: " + student.getEmail());

        Admin.Student existingStudent = studentRepository.findByEmail(student.getEmail());

        if (existingStudent != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new LoginResponse("success", existingStudent.getStudentId(), "success"));
        }

        student.setStudentId(UUID.randomUUID().toString());
        studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new LoginResponse("success", student.getStudentId(), "success"));
    }


    @GetMapping("/{studentId}")
    public ResponseEntity<Admin.Student> getStudent(@PathVariable String studentId) {
        System.out.println("Fetching student details for studentId: " + studentId);

        Admin.Student student = studentRepository.findByStudentId(studentId);
        if (student != null) {
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<Admin.Student> getStudentByEmail(@PathVariable String email) {
        System.out.println("Fetching student details for email: " + email);

        Admin.Student student = studentRepository.findByEmail(email);
        if (student != null) {
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
