package org.example.Service;



import org.example.Entity.SportEvent;
import org.example.Repository.SportEventRepository;
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

