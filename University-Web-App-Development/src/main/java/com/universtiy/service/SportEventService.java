package com.universtiy.service;

import com.university.model.SportEvent;
import com.university.repository.SportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportEventService {

    @Autowired
    private SportEventRepository sportEventRepository;


    public List<SportEvent> getAllSportEvents() {
        return sportEventRepository.findAll();
    }


    public SportEvent createSportEvent(SportEvent sportEvent) {
        return sportEventRepository.save(sportEvent);
    }
}

