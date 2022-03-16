package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Mapper.ExamMapperImpl;
import com.PatManSystem.main.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public List<ExamDTO> getExams(){
       return examRepository.findAll()
               .stream()
               .map(exam -> {
                   return new ExamMapperImpl().examToExamDto(exam);
               })
               .collect(Collectors.toList());
    }
}
