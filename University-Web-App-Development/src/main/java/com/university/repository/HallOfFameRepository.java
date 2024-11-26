package com.university.repository;

import com.university.model.HallOfFame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallOfFameRepository extends JpaRepository<HallOfFame,Long> {

}
