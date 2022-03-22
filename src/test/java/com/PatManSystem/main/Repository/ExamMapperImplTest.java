package com.PatManSystem.main.Repository;

import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Mapper.ExamMapperImpl;
import com.PatManSystem.main.Models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExamMapperImplTest {

    @Autowired
    private final ExamMapperImpl mapper = new ExamMapperImpl();

    @Test
    void examToExamDTOTest(){

        Exam exam = new Exam();
        exam.setId(100);
        exam.setDate(LocalDate.ofEpochDay(2020-12-12));

        Abdomen abdomen = new Abdomen();
        abdomen.setDescription("doing great");

        Lung lung = new Lung();
        lung.setId(111);

        Headandneck headandneck = new Headandneck();
        headandneck.setId(222);

        Oral oral = new Oral();
        oral.setId(333);

        Centralnervoussystem centralnervoussystem = new Centralnervoussystem();
        centralnervoussystem.setId(333);

        exam.setAbdo(abdomen);
        exam.setLung(lung);
        exam.setHn(headandneck);
        exam.setOral(oral);
        exam.setCns(centralnervoussystem);

        ExamDTO examDTO = mapper.examToExamDTO(exam);

        assertEquals(examDTO.getId(), exam.getId());
        assertEquals(examDTO.getDate(), exam.getDate());
        assertEquals(examDTO.getAbdoDescription(), exam.getAbdo().getDescription());
        assertEquals(examDTO.getHnId(), exam.getHn().getId());
        assertEquals(examDTO.getLungId(), exam.getLung().getId());
        assertEquals(examDTO.getOralId(), exam.getOral().getId());
        assertEquals(examDTO.getCnsId(), exam.getCns().getId());

    }

    @Test
    void examDTOToExamTest(){
        ExamDTO examDTO = new ExamDTO();
        examDTO.setId(123);
        examDTO.setAbdoDescription("normal");
        examDTO.setCnsId(111);

        Exam exam = mapper.examDTOToExam(examDTO);

        assertEquals(examDTO.getId(), exam.getId());
        assertEquals(examDTO.getAbdoDescription(), exam.getAbdo().getDescription());
        assertEquals(examDTO.getCnsId(),exam.getCns().getId());
    }

    @Test
    void updateExamFromExamDTOTest(){
        ExamDTO examDTO = new ExamDTO();
        examDTO.setId(123);
        examDTO.setAbdoDescription("normal");
        examDTO.setCnsId(111);

        Exam exam = new Exam();

        mapper.updateExamFromExamDTO(examDTO, exam);
        assertEquals(examDTO.getId(), exam.getId());
        assertEquals(examDTO.getAbdoDescription(), exam.getAbdo().getDescription());
        assertEquals(examDTO.getCnsId(),exam.getCns().getId());
    }

}
