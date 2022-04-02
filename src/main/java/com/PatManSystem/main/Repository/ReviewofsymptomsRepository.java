package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Reviewofsymptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewofsymptomsRepository extends JpaRepository<Reviewofsymptoms, Integer> {
    List<Reviewofsymptoms> findByUli(Patientinformation patientinformation);
}