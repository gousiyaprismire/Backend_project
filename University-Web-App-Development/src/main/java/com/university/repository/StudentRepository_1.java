package com.university.repository;

import com.university.model.Student_1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository_1 extends JpaRepository<Student_1, Long> {
    List<Student_1> findByIsVerifiedFalse();
}