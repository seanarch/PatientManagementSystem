package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofradiationtherapyDTO;
import com.PatManSystem.main.Mapper.TypeofradiationtherapyMapperImpl;
import com.PatManSystem.main.Repository.TypeofradiationtherapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofradiationtherapyService {

    @Autowired
    private TypeofradiationtherapyRepository typeofradiationtherapyRepository;

    public List<TypeofradiationtherapyDTO> getTypeofradiationtherapys(){
        return typeofradiationtherapyRepository.findAll()
                .stream()
                .map(typeofradiationtherapy -> {
                    return new TypeofradiationtherapyMapperImpl().typeofradiationtherapyToTypeofradiationtherapyDto(typeofradiationtherapy);
                })
                .collect(Collectors.toList());
    }
}
