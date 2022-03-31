package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Zrtugi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZrtugiRepository extends JpaRepository<Zrtugi, Integer> {
}