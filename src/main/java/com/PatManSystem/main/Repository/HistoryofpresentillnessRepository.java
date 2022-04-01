package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Historyofpresentillness;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryofpresentillnessRepository extends JpaRepository<Historyofpresentillness, Integer> {
    List<Historyofpresentillness> findByUli(Patientinformation patientinformation);
}