package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DeathDTO;
import com.PatManSystem.main.Mapper.DeathMapperImpl;
import com.PatManSystem.main.Repository.DeathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeathService {

    @Autowired
    private DeathRepository deathRepository;

    public List<DeathDTO> getDeaths(){
        return deathRepository.findAll()
                .stream()
                .map(death -> {
                    return new DeathMapperImpl().deathToDeathDto(death);
                })
                .collect(Collectors.toList());
    }
}
