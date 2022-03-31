package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Zrtlung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZrtlungRepository extends JpaRepository<Zrtlung, Integer> {
}