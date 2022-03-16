package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DiagnosisDTO;
import com.PatManSystem.main.Mapper.DiagnosisMapperImpl;
import com.PatManSystem.main.Repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public List<DiagnosisDTO> getDiagnosiss(){
        return diagnosisRepository.findAll()
                .stream()
                .map(diagnosis -> {
                    return new DiagnosisMapperImpl().diagnosisToDiagnosisDto(diagnosis);
                })
                .collect(Collectors.toList());
    }
}
