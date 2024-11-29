package com.university.serviceImpl;

import com.university.model.HallOfFame;
import com.university.repository.HallOfFameRepository;
import com.university.service.HallOfFameService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class HallOfFameServiceImpl implements HallOfFameService {

    @Autowired
    private HallOfFameRepository hallOfFameRepository;

    public HallOfFame createHallOfFame(HallOfFame hallOfFame) {
        return hallOfFameRepository.save(hallOfFame);
    }

    public List<HallOfFame> getAllHallOfFames() {
        return hallOfFameRepository.findAll();
    }
}
