package com.university.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/map")
public class MapController {

    @GetMapping
    public String maplocation(String location){
        return "University Location";
    }
}
