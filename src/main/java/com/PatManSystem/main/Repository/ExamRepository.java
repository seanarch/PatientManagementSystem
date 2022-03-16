package com.PatManSystem.main.Repository;


import com.PatManSystem.main.Models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
