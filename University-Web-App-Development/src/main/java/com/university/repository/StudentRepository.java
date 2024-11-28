package com.university.repository;

import com.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByEmail(String email);

    Student findByStudentId(String studentId);
}

