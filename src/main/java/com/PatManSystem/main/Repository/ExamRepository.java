package com.PatManSystem.main.Repository;


import com.PatManSystem.main.Models.Exam;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    //@Query("select e from Exam e where e.id = ?1")
    Exam findExamById(Long Id);
    List<Exam> findExamByUli(Patientinformation uli);

    /*@Transactional
    void deleteExamById(Integer id);*/

}
