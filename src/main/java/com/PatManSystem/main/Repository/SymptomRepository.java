package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Integer> {
    List<Symptom> findByUli(Patientinformation patientinformation);
}