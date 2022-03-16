package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Typeofhistoryofpresentillness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofhistoryofpresentillnessRepository extends JpaRepository<Typeofhistoryofpresentillness, Integer> {
}