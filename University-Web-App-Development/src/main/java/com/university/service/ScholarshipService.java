package com.university.service;

import com.university.DTO.ScholarshipSearchDTO;
import com.university.model.Scholarship;
import java.util.List;

public interface ScholarshipService {

    Scholarship createScholarship(Scholarship scholarship);

    List<Scholarship> getAllScholarships();

    List<ScholarshipSearchDTO> searchScholarships(String type, String eligibility);
}
