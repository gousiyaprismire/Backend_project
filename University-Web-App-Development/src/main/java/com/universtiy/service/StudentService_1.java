package com.universtiy.service;

import com.university.model.Student_1;

import java.util.List;

public interface StudentService_1 {

    List<Student_1> getPendingVerifications();

    String approveStudent(Long studentId);

    String rejectStudent(Long studentId, String reason);

    String createStudent(Student_1 student1);
}
