package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofdiagnosticimagingDTO;
import com.PatManSystem.main.Mapper.TypeofdiagnosticimagingMapperImpl;
import com.PatManSystem.main.Repository.TypeofdiagnosticimagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofdiagnosticimagingService {

    @Autowired
    private TypeofdiagnosticimagingRepository typeofdiagnosticimagingRepository;

    public List<TypeofdiagnosticimagingDTO> getTypeofdiagnosticimagings(){
        return typeofdiagnosticimagingRepository.findAll()
                .stream()
                .map(typeofdiagnosticimaging -> {
                    return new TypeofdiagnosticimagingMapperImpl().typeofdiagnosticimagingToTypeofdiagnosticimagingDto(typeofdiagnosticimaging);
                })
                .collect(Collectors.toList());
    }
}
