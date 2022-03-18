package com.PatManSystem.main.Repository;

import com.PatManSystem.main.DTO.ExamDto;
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
    void examToExamDtoTest(){

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

        ExamDto examDto = mapper.examToExamDto(exam);

        assertEquals(examDto.getId(), exam.getId());
        assertEquals(examDto.getDate(), exam.getDate());
        assertEquals(examDto.getAbdoDescription(), exam.getAbdo().getDescription());
        assertEquals(examDto.getHnId(), exam.getHn().getId());
        assertEquals(examDto.getLungId(), exam.getLung().getId());
        assertEquals(examDto.getOralId(), exam.getOral().getId());
        assertEquals(examDto.getCnsId(), exam.getCns().getId());

    }

    @Test
    void examDtoToExamTest(){
        ExamDto examDto = new ExamDto();
        examDto.setId(123);
        examDto.setAbdoDescription("normal");
        examDto.setCnsId(111);

        Exam exam = mapper.examDtoToExam(examDto);

        assertEquals(examDto.getId(), exam.getId());
        assertEquals(examDto.getAbdoDescription(), exam.getAbdo().getDescription());
        assertEquals(examDto.getCnsId(),exam.getCns().getId());
    }

    @Test
    void updateExamFromExamDtoTest(){
        ExamDto examDto = new ExamDto();
        examDto.setId(123);
        examDto.setAbdoDescription("normal");
        examDto.setCnsId(111);

        Exam exam = new Exam();

        mapper.updateExamFromExamDto(examDto, exam);
        assertEquals(examDto.getId(), exam.getId());
        assertEquals(examDto.getAbdoDescription(), exam.getAbdo().getDescription());
        assertEquals(examDto.getCnsId(),exam.getCns().getId());
    }

}
