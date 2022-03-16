package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Pastmedicalhistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastmedicalhistoryRepository extends JpaRepository<Pastmedicalhistory, Integer> {
}