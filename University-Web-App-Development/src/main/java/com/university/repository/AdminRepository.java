package com.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>
{
    Admin findByEmail(String email);
}

