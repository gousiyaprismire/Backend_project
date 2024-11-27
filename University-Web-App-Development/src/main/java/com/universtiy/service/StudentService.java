package com.universtiy.service;

import com.university.model.Student;
import com.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student registerOrLoginStudent(Student student) {
        Optional<Student> existingStudent = Optional.ofNullable(studentRepository.findByEmail(student.getEmail()));

        if (existingStudent.isPresent()) {
            return existingStudent.get();
        }

        return studentRepository.save(student);
    }


    public Optional<Student> getStudentById(String studentId) {
        return studentRepository.findById(studentId);
    }
}
