package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Historyofpresentillness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryofpresentillnessRepository extends JpaRepository<Historyofpresentillness, Integer> {
}