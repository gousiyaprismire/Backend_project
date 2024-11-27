package com.university.repository;

import com.university.model.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScholarshipRepository extends JpaRepository<Scholarship,Long> {
    List<Scholarship> findByTypeAndEligibility(String type, String eligibility);
}
