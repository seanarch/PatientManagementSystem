package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Mrcdyspnoeascale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrcdyspnoeascaleRepository extends JpaRepository<Mrcdyspnoeascale, Integer> {
}