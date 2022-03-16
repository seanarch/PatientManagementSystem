package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.CentralnervoussystemDTO;
import com.PatManSystem.main.Mapper.CentralnervoussystemMapperImpl;
import com.PatManSystem.main.Repository.CentralnervoussystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CentralnervoussystemService {

    @Autowired
    private CentralnervoussystemRepository centralnervoussystemRepository;

    public List<CentralnervoussystemDTO> getCentralnervoussystems(){
        return centralnervoussystemRepository.findAll()
                .stream()
                .map(centralnervoussystem -> {
                    return new CentralnervoussystemMapperImpl().centralnervoussystemToCentralnervoussystemDto(centralnervoussystem);
                })
                .collect(Collectors.toList());
    }
}
