package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Childpugh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildpughRepository extends JpaRepository<Childpugh, Integer> {
}