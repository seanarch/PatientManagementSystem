package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Assess;
import com.PatManSystem.main.Models.Exam;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessRepository extends JpaRepository<Assess, Integer> {
    List<Assess> findAssessByUli(Patientinformation uli);
}