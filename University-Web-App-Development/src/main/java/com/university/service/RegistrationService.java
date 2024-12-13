package com.university.service;


import com.university.model.StudentRegistration;
import com.university.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    // Register a new student
    public void registerStudent(StudentRegistration student) {
        studentRegistrationRepository.save(student);
    }

    // Get all students
    public List<StudentRegistration> getAllStudents() {
        return studentRegistrationRepository.findAll();
    }

    // Get student by ID
    public Optional<StudentRegistration> getStudentById(Long id) {
        return studentRegistrationRepository.findById(id);
    }

    // Save updated student
    public StudentRegistration saveStudent(StudentRegistration student) {
        return studentRegistrationRepository.save(student);
    }
}
