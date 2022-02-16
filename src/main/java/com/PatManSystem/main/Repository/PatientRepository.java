package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.PtId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PtId, Long> {
}
