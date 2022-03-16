package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Zrtlgi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZrtlgiRepository extends JpaRepository<Zrtlgi, Integer> {
}