package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.SymptomDTO;
import com.PatManSystem.main.Mapper.SymptomMapperImpl;
import com.PatManSystem.main.Repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    public List<SymptomDTO> getSymptoms(){
        return symptomRepository.findAll()
                .stream()
                .map(symptom -> {
                    return new SymptomMapperImpl().symptomToSymptomDTO(symptom);
                })
                .collect(Collectors.toList());
    }
}
