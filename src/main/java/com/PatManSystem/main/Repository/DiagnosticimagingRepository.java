package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Diagnosticimaging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticimagingRepository extends JpaRepository<Diagnosticimaging, Integer> {
}