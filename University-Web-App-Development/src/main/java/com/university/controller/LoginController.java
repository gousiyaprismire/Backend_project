package com.university.controller;

import com.university.DTO.LoginResponse;
import com.university.model.Student;
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
    public ResponseEntity<LoginResponse> login(@RequestBody Student student) {
        System.out.println("Login attempt for student: " + student.getEmail());

        Student existingStudent = studentRepository.findByEmail(student.getEmail());

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
    public ResponseEntity<Student> getStudent(@PathVariable String studentId) {
        System.out.println("Fetching student details for studentId: " + studentId);

        Student student = studentRepository.findByStudentId(studentId);
        if (student != null) {
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        System.out.println("Fetching student details for email: " + email);

        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
