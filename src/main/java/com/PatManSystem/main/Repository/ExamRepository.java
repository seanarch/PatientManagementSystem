package com.PatManSystem.main.Repository;


import com.PatManSystem.main.Models.Exam;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    Exam findExamById(Long Id);
    List<Exam> findExamByUli(Patientinformation uli);
}
