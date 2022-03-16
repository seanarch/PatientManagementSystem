package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofmanagementDTO;
import com.PatManSystem.main.Mapper.TypeofmanagementMapperImpl;
import com.PatManSystem.main.Repository.TypeofmanagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofmanagementService {

    @Autowired
    private TypeofmanagementRepository typeofmanagementRepository;

    public List<TypeofmanagementDTO> getTypeofmanagements(){
        return typeofmanagementRepository.findAll()
                .stream()
                .map(typeofmanagement -> {
                    return new TypeofmanagementMapperImpl().typeofmanagementToTypeofmanagementDto(typeofmanagement);
                })
                .collect(Collectors.toList());
    }
}
