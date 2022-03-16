package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Zfu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZfuRepository extends JpaRepository<Zfu, Integer> {
}