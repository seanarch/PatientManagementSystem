package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.GoalofcareDTO;
import com.PatManSystem.main.Mapper.GoalofcareMapperImpl;
import com.PatManSystem.main.Repository.GoalofcareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalofcareService {

    @Autowired
    private GoalofcareRepository goalofcareRepository;

    public List<GoalofcareDTO> getGoalofcares(){
        return goalofcareRepository.findAll()
                .stream()
                .map(goalofcare -> {
                    return new GoalofcareMapperImpl().goalofcareToGoalofcareDto(goalofcare);
                })
                .collect(Collectors.toList());
    }
}
