package com.university.serviceImpl;

import com.university.DTO.ScholarshipSearchDTO;
import com.university.model.Scholarship;
import com.university.repository.ScholarshipRepository;
import com.university.service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScholarshipServiceImpl implements ScholarshipService {

    @Autowired
    private ScholarshipRepository scholarshipRepository;

    @Override
    public Scholarship createScholarship(Scholarship scholarship) {
        return scholarshipRepository.save(scholarship);
    }

    @Override
    public List<Scholarship> getAllScholarships() {
        return scholarshipRepository.findAll();
    }

    @Override
    public List<ScholarshipSearchDTO> searchScholarships(String type, String eligibility) {
        List<Scholarship> scholarships = scholarshipRepository.findAll();
        List<ScholarshipSearchDTO> result = new ArrayList<>();

        for (Scholarship scholarship : scholarships) {
            boolean matches = true;

            if (type != null && !scholarship.getType().equalsIgnoreCase(type)) {
                matches = false;
            }
            if (eligibility != null && !scholarship.getEligibility().equalsIgnoreCase(eligibility)) {
                matches = false;
            }

            if (matches) {
                String duration = "4years";

                ScholarshipSearchDTO searchDTO = new ScholarshipSearchDTO(
                        scholarship.getName(),
                        scholarship.getEligibility(),
                        duration,
                        scholarship.getBenefits(),
                        scholarship.getEligibility()
                );
                result.add(searchDTO);
            }
        }
        return result;
    }
}
