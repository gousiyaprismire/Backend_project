package com.university.controller;

import com.university.model.CollegeMap;
import com.university.serviceImpl.CollegeMapSerivceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/college/map")
@AllArgsConstructor
public class CollegeMapController {
    @Autowired
    private CollegeMapSerivceImpl collegeMapSerivce;
    @PostMapping("/addmap")
    public ResponseEntity<CollegeMap> addmap(@RequestBody CollegeMap collegeMap){
        CollegeMap collegeMap1 = collegeMapSerivce.addMap(collegeMap);
        return new ResponseEntity<>(collegeMap1, HttpStatus.OK);
    }
    @GetMapping("/allmaps")
    public ResponseEntity<List<CollegeMap>> getAllMaps(){
        List<CollegeMap> collegeMap= collegeMapSerivce.getAllMap();
        return new ResponseEntity<>(collegeMap, HttpStatus.OK);
    }

}
