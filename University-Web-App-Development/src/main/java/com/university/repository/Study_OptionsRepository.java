package com.university.repository;

import com.university.model.Study_Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Study_OptionsRepository extends JpaRepository<Study_Options, Integer>
{

    List<Study_Options> findByLevel(String level);
}
