package com.university.repository;
import com.university.model.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {
    Optional<StudentRegistration> findByEmailOrUsername(String email, String username);
    StudentRegistration findByEmail(String email);
}

