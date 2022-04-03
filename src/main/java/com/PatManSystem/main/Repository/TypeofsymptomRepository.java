package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Typeofrecure;
import com.PatManSystem.main.Models.Typeofsymptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofsymptomRepository extends JpaRepository<Typeofsymptom, Integer> {
}
