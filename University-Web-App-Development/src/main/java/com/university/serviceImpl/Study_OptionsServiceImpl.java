package com.university.serviceImpl;

import com.university.model.Study_Options;
import com.university.repository.Study_OptionsRepository;
import com.university.service.Study_OptionsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Study_OptionsServiceImpl implements Study_OptionsService {

    private final Study_OptionsRepository study_OptionsRepository;

    public Study_OptionsServiceImpl(Study_OptionsRepository studyOptionsRepository) {
        study_OptionsRepository = studyOptionsRepository;
    }

    @Override
    public Study_Options createStudyOption(Study_Options studyOption) {
        return study_OptionsRepository.save(studyOption);
    }


    @Override
    public List<Study_Options> getAllStudyOptions() {
        return study_OptionsRepository.findAll();
    }


    @Override
    public List<Study_Options> getStudyOptionsByLevel(String level) {
        return study_OptionsRepository.findByLevel(level);
    }
}
