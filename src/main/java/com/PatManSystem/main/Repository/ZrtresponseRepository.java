package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Zrtresponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZrtresponseRepository extends JpaRepository<Zrtresponse, Integer> {
}