package com.universtiy.service;

import com.university.model.CollegeMap;

import java.util.List;

public interface CollegeMapService {
    public CollegeMap addMap(CollegeMap collegeMap);
    public List<CollegeMap> getAllMap();
}
