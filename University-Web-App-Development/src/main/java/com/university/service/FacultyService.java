package com.university.service;


import com.university.model.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
     List<Faculty> getAllFaculty();
     Faculty saveFaculty(Faculty faculty);
    Optional<Faculty> getFacultyById(Long id);

}
