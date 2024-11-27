package org.example.Repository;



import org.example.Entity.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportEventRepository extends JpaRepository<SportEvent, Long> {


}

