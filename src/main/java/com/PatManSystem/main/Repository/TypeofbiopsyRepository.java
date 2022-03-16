package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Typeofbiopsy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofbiopsyRepository extends JpaRepository<Typeofbiopsy, Integer> {
}