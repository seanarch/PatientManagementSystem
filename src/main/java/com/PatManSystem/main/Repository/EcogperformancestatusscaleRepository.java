package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Ecogperformancestatusscale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcogperformancestatusscaleRepository extends JpaRepository<Ecogperformancestatusscale, Integer> {
}