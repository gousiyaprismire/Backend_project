package com.universtiy.service;

import com.university.model.HallOfFame;

import java.util.List;

public interface HallOfFameService {

    HallOfFame createHallOfFame(HallOfFame hallOfFame);

    List<HallOfFame> getAllHallOfFames();
}
