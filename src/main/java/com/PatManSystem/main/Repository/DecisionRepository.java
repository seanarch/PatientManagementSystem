package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, Integer> {
}