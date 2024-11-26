package com.university.controller;

//import com.university.DTO.ScholarshipSearchDTO;
import com.university.model.Scholarship;
import com.university.serviceImpl.ScholarshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/college/scholarships")
public class ScholarshipController {

    @Autowired
    private ScholarshipServiceImpl scholarshipService;

    @GetMapping                 //to get all the Scholarship details
    public ResponseEntity<List<Scholarship>> getAllScholarships() {
        List<Scholarship> scholarships = scholarshipService.getAllScholarships();
        return new ResponseEntity<>(scholarships, HttpStatus.OK);
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<ScholarshipSearchDTO>> searchScholarships(
//            @RequestParam String type,
//            @RequestParam String eligibility) {
//
//        System.out.println(type+" and "+eligibility);
//        List<ScholarshipSearchDTO> searchResults = scholarshipService.searchScholarships(type, eligibility);
//        return new ResponseEntity<>(searchResults, HttpStatus.OK);
//    }

    @PostMapping   //to create new Scholarships
    public ResponseEntity<Scholarship> saveScholarship(@RequestBody Scholarship scholarship) {
        Scholarship savedScholarship = scholarshipService.saveScholarship(scholarship);
        return new ResponseEntity<>(savedScholarship, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scholarship> getScholarshipById(@PathVariable Long id) {
        Optional<Scholarship> scholarship = scholarshipService.getScholarshipById(id);
        if (scholarship.isPresent()) {
            return new ResponseEntity<>(scholarship.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}