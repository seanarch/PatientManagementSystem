package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Death;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathRepository extends JpaRepository<Death, Integer> {
}