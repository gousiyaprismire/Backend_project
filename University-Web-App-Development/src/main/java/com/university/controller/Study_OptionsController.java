package com.university.controller;

import com.university.model.Study_Options;
import com.university.serviceImpl.Study_OptionsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/college/study-options")
public class Study_OptionsController {

    private final Study_OptionsServiceImpl study_OptionsServiceImpl;


    @PostMapping
    public ResponseEntity<Study_Options> createStudyOption(@RequestBody Study_Options studyOption) {
        Study_Options createdStudyOption = study_OptionsServiceImpl.createStudyOption(studyOption);
        return new ResponseEntity<>(createdStudyOption, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Study_Options>> getAllStudyOptions() {
        List<Study_Options> studyOptions = study_OptionsServiceImpl.getAllStudyOptions();
        if (studyOptions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studyOptions, HttpStatus.OK);
    }

    // Get Study Options by level
    @GetMapping("/level/{level}")
    public ResponseEntity<List<Study_Options>> getStudyOptionsByLevel(@PathVariable String level) {
        List<Study_Options> studyOptionsByLevel = study_OptionsServiceImpl.getStudyOptionsByLevel(level);
        if (studyOptionsByLevel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studyOptionsByLevel, HttpStatus.OK);
    }
}
