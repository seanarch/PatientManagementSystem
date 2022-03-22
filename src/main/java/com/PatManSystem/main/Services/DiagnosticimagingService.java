package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DiagnosticimagingDTO;
import com.PatManSystem.main.Mapper.DiagnosticimagingMapperImpl;
import com.PatManSystem.main.Repository.DiagnosticimagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosticimagingService {

    @Autowired
    private DiagnosticimagingRepository diagnosticimagingRepository;

    public List<DiagnosticimagingDTO> getDiagnosticimagings(){
        return diagnosticimagingRepository.findAll()
                .stream()
                .map(diagnosticimaging -> {
                    return new DiagnosticimagingMapperImpl().diagnosticimagingToDiagnosticimagingDTO(diagnosticimaging);
                })
                .collect(Collectors.toList());
    }
}
