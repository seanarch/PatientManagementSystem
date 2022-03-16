package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Typeofradiationtherapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofradiationtherapyRepository extends JpaRepository<Typeofradiationtherapy, Integer> {
}