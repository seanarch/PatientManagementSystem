package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Zrtskin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZrtskinRepository extends JpaRepository<Zrtskin, Integer> {
}