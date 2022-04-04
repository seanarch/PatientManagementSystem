package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Decision;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, Integer> {
    List<Decision> findByUli(Patientinformation patientinformation);
}