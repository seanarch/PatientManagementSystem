package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.RadiationtherapyDTO;
import com.PatManSystem.main.Mapper.RadiationtherapyMapperImpl;
import com.PatManSystem.main.Repository.RadiationtherapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RadiationtherapyService {

    @Autowired
    private RadiationtherapyRepository radiationtherapyRepository;

    public List<RadiationtherapyDTO> getRadiationtherapys(){
        return radiationtherapyRepository.findAll()
                .stream()
                .map(radiationtherapy -> {
                    return new RadiationtherapyMapperImpl().radiationtherapyToRadiationtherapyDto(radiationtherapy);
                })
                .collect(Collectors.toList());
    }
}
