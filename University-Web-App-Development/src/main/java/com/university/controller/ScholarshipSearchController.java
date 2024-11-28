package com.university.controller;

import com.university.DTO.ScholarshipSearchDTO;
import com.university.serviceImpl.ScholarshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/college/scholarships/search")
public class ScholarshipSearchController {

    @Autowired
    private ScholarshipServiceImpl scholarshipService;

    @PostMapping
    public List<ScholarshipSearchDTO> searchScholarships(@RequestBody ScholarshipSearchDTO searchDTO) {
        return scholarshipService.searchScholarships(searchDTO.getLevel(), searchDTO.getEntryRequirements());
    }

    @GetMapping
    public List<ScholarshipSearchDTO> searchScholarships(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "eligibility", required = false) String eligibility) {
        return scholarshipService.searchScholarships(type, eligibility);
    }
}