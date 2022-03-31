package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patientinformation, Long> {

    Patientinformation findPatientinformationById(Long Id);
}
