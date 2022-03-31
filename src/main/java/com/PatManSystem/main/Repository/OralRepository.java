package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Oral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OralRepository extends JpaRepository<Oral, Integer> {
}