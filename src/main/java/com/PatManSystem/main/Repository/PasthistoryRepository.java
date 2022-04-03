package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Pasthistory;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasthistoryRepository extends JpaRepository<Pasthistory, Integer> {
    Pasthistory findPasthistoryById(Integer Id);
    List<Pasthistory> findPasthistoryByUli(Patientinformation patientinformation);
}