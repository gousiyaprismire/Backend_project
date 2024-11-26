package com.university.serviceImpl;

import com.university.model.Student_1;
import com.university.repository.StudentRepository_1;
import com.universtiy.service.StudentService_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl_1 implements StudentService_1 {

    @Autowired
    private StudentRepository_1 studentRepository1;

    @Override
    public List<Student_1> getPendingVerifications() {
        return studentRepository1.findByIsVerifiedFalse();
    }

    @Override
    @Transactional
    public String approveStudent(Long studentId) {
        Optional<Student_1> studentOpt = studentRepository1.findById(studentId);

        if (studentOpt.isPresent()) {
            Student_1 student1 = studentOpt.get();
            student1.setVerified(true);
            studentRepository1.save(student1);
            return "Student successfully approved";
        } else {
            return "Student not found";
        }
    }

    @Override
    @Transactional
    public String rejectStudent(Long studentId, String reason) {
        Optional<Student_1> studentOpt = studentRepository1.findById(studentId);

        if (studentOpt.isPresent()) {
            Student_1 student1 = studentOpt.get();
            student1.setVerified(false);
            studentRepository1.save(student1);
            return "Student successfully rejected: " + reason;
        } else {
            return "Student not found";
        }
    }

    @Override
    @Transactional
    public String createStudent(Student_1 student1) {
        studentRepository1.save(student1);
        return "Student created successfully!";
    }
}
