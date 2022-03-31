package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Typeofdecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofdecisionRepository extends JpaRepository<Typeofdecision, Integer> {
}