package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Zrthep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZrthepRepository extends JpaRepository<Zrthep, Integer> {
}