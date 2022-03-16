package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Mapper.ExamMapperImpl;
import com.PatManSystem.main.Models.Exam;
import com.PatManSystem.main.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    ExamMapperImpl examMapperImpl =  new ExamMapperImpl();

    public List<ExamDTO> getExams(){

       List<Exam> examList =  examRepository.findAll();
       List<ExamDTO> examDTOList = new ArrayList<ExamDTO>();

        for(Exam exam: examList){
           examDTOList.add(examMapperImpl.examToExamDto(exam));
       }

        return examDTOList;

    }



}
