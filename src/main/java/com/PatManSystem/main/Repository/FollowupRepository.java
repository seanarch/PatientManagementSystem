package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Followup;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowupRepository extends JpaRepository<Followup, Integer> {
    List<Followup> findByUli(Patientinformation patientinformation);
}