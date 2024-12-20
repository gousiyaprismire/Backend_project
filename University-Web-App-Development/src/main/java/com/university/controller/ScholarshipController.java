package com.university.controller;

import com.university.model.Scholarship;
import com.university.serviceImpl.ScholarshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/college/scholarships")
public class ScholarshipController {

    @Autowired
    private ScholarshipServiceImpl scholarshipService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Scholarship createScholarship(@RequestBody Scholarship scholarship) {
        return scholarshipService.createScholarship(scholarship);
    }

    @GetMapping
    public List<Scholarship> getAllScholarships() {
        return scholarshipService.getAllScholarships();
    }
}
