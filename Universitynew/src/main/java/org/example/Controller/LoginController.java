package org.example.Controller;

import lombok.AllArgsConstructor;
import org.example.DTO.LoginResponse;
import org.example.Entity.Student;
import org.example.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
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


        //student.setStudentId(Long.valueOf(UUID.randomUUID().toString()));
        studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new LoginResponse("success", student.getStudentId(), "success"));
    }


    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getStudentById(@RequestParam String studentId) {
        Student existingStudent = studentRepository.findById(studentId).orElse(null);

        if (existingStudent != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new LoginResponse("success", existingStudent.getStudentId(), "success"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new LoginResponse("error", null, "Student not found"));
    }
}
