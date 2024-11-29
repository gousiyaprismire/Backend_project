package com.university.serviceImpl;

import com.university.model.CollegeMap;
import com.university.repository.CollegeMapRepository;
import com.university.service.CollegeMapService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CollegeMapSerivceImpl implements CollegeMapService {
    @Autowired
    private CollegeMapRepository collegeMapRepository;
    @Override
    public CollegeMap addMap(CollegeMap collegeMap) {
        return collegeMapRepository.save(collegeMap);
    }
    @Override
    public List<CollegeMap> getAllMap(){
        return collegeMapRepository.findAll();
    }
}
