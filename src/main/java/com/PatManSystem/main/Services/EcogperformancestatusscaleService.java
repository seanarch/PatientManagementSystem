package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.EcogperformancestatusscaleDTO;
import com.PatManSystem.main.Mapper.EcogperformancestatusscaleMapperImpl;
import com.PatManSystem.main.Repository.EcogperformancestatusscaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EcogperformancestatusscaleService {

    @Autowired
    private EcogperformancestatusscaleRepository ecogperformancestatusscaleRepository;

    public List<EcogperformancestatusscaleDTO> getEcogperformancestatusscales(){
        return ecogperformancestatusscaleRepository.findAll()
                .stream()
                .map(ecogperformancestatusscale -> {
                    return new EcogperformancestatusscaleMapperImpl().ecogperformancestatusscaleToEcogperformancestatusscaleDto(ecogperformancestatusscale);
                })
                .collect(Collectors.toList());
    }
}
