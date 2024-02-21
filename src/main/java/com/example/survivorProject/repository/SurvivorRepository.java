package com.example.survivorProject.repository;

import com.example.survivorProject.entity.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {
    List<Survivor> findByInfected(boolean infected);
    long countByInfected(boolean infected);
}
