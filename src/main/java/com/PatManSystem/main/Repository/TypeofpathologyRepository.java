package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Typeofpathology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofpathologyRepository extends JpaRepository<Typeofpathology, Integer> {
}