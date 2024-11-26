package com.university.serviceImpl;

import com.university.model.Study_Options;
import com.university.repository.Study_OptionsRepository;
import com.universtiy.service.Study_OptionsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Study_OptionsServiceImpl implements Study_OptionsService {

    private final Study_OptionsRepository study_OptionsRepository;

    @Override
    public Study_Options createStudyOption(Study_Options studyOption) {
        return study_OptionsRepository.save(studyOption);
    }

    // Method to get all Study_Options
    @Override
    public List<Study_Options> getAllStudyOptions() {
        return study_OptionsRepository.findAll();
    }

    // Method to get Study_Options by level
    @Override
    public List<Study_Options> getStudyOptionsByLevel(String level) {
        return study_OptionsRepository.findByLevel(level);
    }
}
