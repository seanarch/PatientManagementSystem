package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Bodylocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodylocationRepository extends JpaRepository<Bodylocation, Integer> {
}