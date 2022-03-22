package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DecisionDTO;
import com.PatManSystem.main.Mapper.DecisionMapperImpl;
import com.PatManSystem.main.Repository.DecisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DecisionService {

    @Autowired
    private DecisionRepository decisionRepository;

    public List<DecisionDTO> getDecisions(){
        return decisionRepository.findAll()
                .stream()
                .map(decision -> {
                    return new DecisionMapperImpl().decisionToDecisionDTO(decision);
                })
                .collect(Collectors.toList());
    }
}