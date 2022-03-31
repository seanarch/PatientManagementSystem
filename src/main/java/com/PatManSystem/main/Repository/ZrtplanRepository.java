package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Zrtplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZrtplanRepository extends JpaRepository<Zrtplan, Integer> {
}