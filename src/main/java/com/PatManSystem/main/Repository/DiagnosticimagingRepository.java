package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Diagnosticimaging;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosticimagingRepository extends JpaRepository<Diagnosticimaging, Integer> {
    List<Diagnosticimaging> findByUli(Patientinformation patientinformation);
}