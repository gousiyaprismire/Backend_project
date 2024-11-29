package com.university.controller;


import com.university.model.Student_1;
import com.university.service.StudentService_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/verification")
public class StudentController_1 {

    @Autowired
    private StudentService_1 studentService1;

    @GetMapping("/pending")
    public List<Student_1> getPendingVerifications() {
        return studentService1.getPendingVerifications();
    }

    @PostMapping("/approve")
    public String approveStudent(@RequestBody Long studentId) {
        return studentService1.approveStudent(studentId);
    }

    @PostMapping("/reject")
    public String rejectStudent(@RequestBody Map<String, Object> rejectRequest) {
        Long studentId = Long.valueOf(rejectRequest.get("studentId").toString());
        String reason = (String) rejectRequest.get("reason");

        return studentService1.rejectStudent(studentId, reason);
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student_1 student1) {
        return studentService1.createStudent(student1);
    }
}
