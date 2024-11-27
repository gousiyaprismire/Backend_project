package org.example.Controller;


import org.example.Entity.SportEvent;
import org.example.Repository.SportEventRepository;
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
        return sportEventRepository.findAll(); // Fetch all events from the database
    }

    @PostMapping("/sports")
    public ResponseEntity<String> createSportEvent(@RequestBody SportEvent sportEvent) {
        // Save the new sport event to the database
        sportEventRepository.save(sportEvent);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Sport event created successfully.");
    }
}

