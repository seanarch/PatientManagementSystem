package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.AssessDTO;
import com.PatManSystem.main.Mapper.AssessMapperImpl;
import com.PatManSystem.main.Repository.AssessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssessService {

@Autowired
private AssessRepository assessRepository;

    public List<AssessDTO> getAssesss(){
        return assessRepository.findAll()
        .stream()
        .map(assess -> {
            return new AssessMapperImpl().assessToAssessDto(assess);
        })
        .collect(Collectors.toList());
    }
}