package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Radiationtherapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RadiationtherapyRepository extends JpaRepository<Radiationtherapy, Integer> {
    List<Radiationtherapy> findByUli(Patientinformation patientinformation);
}