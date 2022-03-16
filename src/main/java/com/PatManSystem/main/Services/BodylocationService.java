package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.BodylocationDTO;
import com.PatManSystem.main.Mapper.BodylocationMapperImpl;
import com.PatManSystem.main.Repository.BodylocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BodylocationService {

    @Autowired
    private BodylocationRepository bodylocationRepository;

    public List<BodylocationDTO> getBodylocations() {
        return bodylocationRepository.findAll()
                .stream()
                .map(bodylocation -> {
                    return new BodylocationMapperImpl().bodylocationToBodylocationDto(bodylocation);
                })
                .collect(Collectors.toList());
    }
}