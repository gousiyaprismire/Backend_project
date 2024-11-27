package com.university.controller;

import com.university.model.SportEvent;
import com.university.repository.SportEventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/college")
public class SportsController {

    private final SportEventRepository sportEventRepository;

    public SportsController(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    @GetMapping("/sports")
    public List<SportEvent> getSportsInfo() {
        return sportEventRepository.findAll();
    }

    @PostMapping("/sports")
    public ResponseEntity<String> createSportEvent(@RequestBody SportEvent sportEvent) {

        sportEventRepository.save(sportEvent);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Sport event created successfully.");
    }
}
