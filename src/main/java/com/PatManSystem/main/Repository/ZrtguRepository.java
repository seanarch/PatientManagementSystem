package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Zrtgu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZrtguRepository extends JpaRepository<Zrtgu, Integer> {
}