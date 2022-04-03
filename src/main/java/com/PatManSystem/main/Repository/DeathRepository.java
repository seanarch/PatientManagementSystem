package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Death;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeathRepository extends JpaRepository<Death, Integer> {
    List<Death> findByUli(Patientinformation patientinformation);
}