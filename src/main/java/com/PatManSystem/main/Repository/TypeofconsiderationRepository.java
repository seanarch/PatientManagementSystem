package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Typeofconsideration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofconsiderationRepository extends JpaRepository<Typeofconsideration, Integer> {
}