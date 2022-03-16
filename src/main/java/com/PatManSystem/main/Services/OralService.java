package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.OralDTO;
import com.PatManSystem.main.Mapper.OralMapperImpl;
import com.PatManSystem.main.Repository.OralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OralService {

    @Autowired
    private OralRepository oralRepository;

    public List<OralDTO> getOrals(){
        return oralRepository.findAll()
                .stream()
                .map(oral -> {
                    return new OralMapperImpl().oralToOralDto(oral);
                })
                .collect(Collectors.toList());
    }
}
