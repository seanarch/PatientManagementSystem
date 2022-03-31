package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ManagementDTO;
import com.PatManSystem.main.Mapper.ManagementMapperImpl;
import com.PatManSystem.main.Repository.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagementService {

    @Autowired
    private ManagementRepository managementRepository;

    public List<ManagementDTO> getManagements(){
        return managementRepository.findAll()
                .stream()
                .map(management -> {
                    return new ManagementMapperImpl().managementToManagementDTO(management);
                })
                .collect(Collectors.toList());
    }
}
