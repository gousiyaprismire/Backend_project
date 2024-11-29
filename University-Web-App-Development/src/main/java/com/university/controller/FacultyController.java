package com.university.controller;

import com.university.model.Faculty;
import com.university.serviceImpl.FacultyServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/college/faculty")

public class FacultyController {
    @Autowired
    private FacultyServiceImpl facultyService;
    @GetMapping
    public ResponseEntity<List<Faculty>> getFacultyInfo() {
        List<Faculty> faculties = facultyService.getAllFaculty();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Optional<Faculty> faculty = facultyService.getFacultyById(id);
        return faculty.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Faculty> SaveFaculty(@RequestBody Faculty faculty) {
        Faculty savedFaculty = facultyService.saveFaculty(faculty);
        return new ResponseEntity<>(savedFaculty, HttpStatus.CREATED);
    }

}

