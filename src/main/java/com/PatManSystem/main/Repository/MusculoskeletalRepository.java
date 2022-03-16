package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Musculoskeletal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusculoskeletalRepository extends JpaRepository<Musculoskeletal, Integer> {
}