package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Abdomen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbdomenRepository extends JpaRepository<Abdomen, Integer> {
}