package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Newpatientconsult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewpatientconsultRepository extends JpaRepository<Newpatientconsult, Integer> {
}