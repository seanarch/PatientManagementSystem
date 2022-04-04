package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Pulmonaryfunctiontest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PulmonaryfunctiontestRepository extends JpaRepository<Pulmonaryfunctiontest, Integer> {
    Pulmonaryfunctiontest findPulmonaryfunctiontestById(Integer id);
    List<Pulmonaryfunctiontest> findPulmonaryfunctiontestByUli(Patientinformation patientinformation);
}