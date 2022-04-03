package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Pastmedicalhistory;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PastmedicalhistoryRepository extends JpaRepository<Pastmedicalhistory, Integer> {
    Pastmedicalhistory findPastmedicalhistoryById(Integer id);
    List<Pastmedicalhistory> findPastmedicalhistoryByUli(Patientinformation patientinformation);
}