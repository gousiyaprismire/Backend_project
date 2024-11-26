package com.university.repository;

import com.university.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Admin.Student, String> {
    Admin.Student findByEmail(String email);

    Admin.Student findByStudentId(String studentId);
}

