package com.university.serviceImpl;

import com.university.model.Faculty;
import com.university.repository.FacultyRepository;
import com.universtiy.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculty() {

        return facultyRepository.findAll();
    }

    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty); }

    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }
}

