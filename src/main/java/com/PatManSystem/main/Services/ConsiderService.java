package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ConsiderDTO;
import com.PatManSystem.main.Mapper.ConsiderMapperImpl;
import com.PatManSystem.main.Repository.ConsiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsiderService {

    @Autowired
    private ConsiderRepository considerRepository;

    public List<ConsiderDTO> getConsiders(){
        return considerRepository.findAll()
                .stream()
                .map(consider -> {
                    return new ConsiderMapperImpl().considerToConsiderDTO(consider);
                })
                .collect(Collectors.toList());
    }
}