package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Lung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LungRepository extends JpaRepository<Lung, Integer> {
}