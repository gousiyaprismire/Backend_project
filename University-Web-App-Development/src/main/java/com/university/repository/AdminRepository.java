package com.university.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.university.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer> {
    public Admin findByName(String name);
}


