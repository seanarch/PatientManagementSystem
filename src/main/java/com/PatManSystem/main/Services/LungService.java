package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.LungDTO;
import com.PatManSystem.main.Mapper.LungMapperImpl;
import com.PatManSystem.main.Repository.LungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LungService {

    @Autowired
    private LungRepository lungRepository;

    public List<LungDTO> getLungs(){
        return lungRepository.findAll()
                .stream()
                .map(lung -> {
                    return new LungMapperImpl().lungToLungDto(lung);
                })
                .collect(Collectors.toList());
    }
}
