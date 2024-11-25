package com.university.repository;

import com.university.Entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByEmail(String email);
}

