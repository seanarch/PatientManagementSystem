package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Pasthistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasthistoryRepository extends JpaRepository<Pasthistory, Integer> {
}