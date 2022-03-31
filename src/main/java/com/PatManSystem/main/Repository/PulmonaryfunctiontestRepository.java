package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Pulmonaryfunctiontest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PulmonaryfunctiontestRepository extends JpaRepository<Pulmonaryfunctiontest, Integer> {
}