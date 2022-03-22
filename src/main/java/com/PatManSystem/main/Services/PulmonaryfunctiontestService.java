package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.PulmonaryfunctiontestDTO;
import com.PatManSystem.main.Mapper.PulmonaryfunctiontestMapperImpl;
import com.PatManSystem.main.Repository.PulmonaryfunctiontestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PulmonaryfunctiontestService {

    @Autowired
    private PulmonaryfunctiontestRepository pulmonaryfunctiontestRepository;

    public List<PulmonaryfunctiontestDTO> getPulmonaryfunctiontests(){
        return pulmonaryfunctiontestRepository.findAll()
                .stream()
                .map(pulmonaryfunctiontest -> {
                    return new PulmonaryfunctiontestMapperImpl().pulmonaryfunctiontestToPulmonaryfunctiontestDTO(pulmonaryfunctiontest);
                })
                .collect(Collectors.toList());
    }
}
