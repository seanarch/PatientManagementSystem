package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Diagnosis;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
    List<Diagnosis> findByUli(Patientinformation patientinformation);
}