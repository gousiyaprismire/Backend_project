package com.universtiy.service;

import com.university.DTO.ScholarshipSearchDTO;
import com.university.model.Scholarship;

import java.util.List;
import java.util.Optional;

public interface ScholarshipService {

    List<Scholarship> getAllScholarships();
    //List<ScholarshipSearchDTO> searchScholarships(String type, String eligibility);
    Scholarship saveScholarship(Scholarship scholarship);
    Optional<Scholarship> getScholarshipById(Long id);
}
