package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.BreathDTO;
import com.PatManSystem.main.Mapper.BreathMapperImpl;
import com.PatManSystem.main.Repository.BreathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreathService {

@Autowired
private BreathRepository breathRepository;

        public List<BreathDTO> getBreaths(){
            return breathRepository.findAll()
            .stream()
            .map(breath -> {
                return new BreathMapperImpl().breathToBreathDto(breath);
            })
            .collect(Collectors.toList());
        }
}