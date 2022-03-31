package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Followup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowupRepository extends JpaRepository<Followup, Integer> {
}