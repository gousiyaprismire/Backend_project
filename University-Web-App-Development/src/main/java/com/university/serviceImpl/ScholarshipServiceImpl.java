package com.university.serviceImpl;

import com.university.DTO.ScholarshipSearchDTO;
import com.university.model.Scholarship;
import com.university.repository.ScholarshipRepository;
import com.universtiy.service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScholarshipServiceImpl implements ScholarshipService {

    @Autowired
    private ScholarshipRepository scholarshipRepository;

    @Override
    public List<Scholarship> getAllScholarships() {
        return scholarshipRepository.findAll();
    }

//    @Override
//    public List<ScholarshipSearchDTO> searchScholarships(String type, String eligibility) {
//
//        List<Scholarship> scholarships = scholarshipRepository.findByTypeAndEligibility(type, eligibility);
//        List<ScholarshipSearchDTO> result = new ArrayList<>();
//
//        for (Scholarship scholarship : scholarships) {
//            ScholarshipSearchDTO dto = new ScholarshipSearchDTO(
//                    scholarship.getName(),
//                    scholarship.getEligibility(),
//                    "2 years",
//                    "Description for " + scholarship.getName(),
//                    "Entry requirements for " + scholarship.getName()
//            );
//            result.add(dto);
//        }
//        return result;
//    }

    @Override
    public Scholarship saveScholarship(Scholarship scholarship) {
        return scholarshipRepository.save(scholarship);
    }

    @Override
    public Optional<Scholarship> getScholarshipById(Long id) {
        return scholarshipRepository.findById(id);
    }
}
