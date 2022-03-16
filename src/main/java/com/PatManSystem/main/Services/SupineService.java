package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.SupineDTO;
import com.PatManSystem.main.Mapper.SupineMapperImpl;
import com.PatManSystem.main.Repository.SupineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupineService {

    @Autowired
    private SupineRepository supineRepository;

    public List<SupineDTO> getSupines(){
        return supineRepository.findAll()
                .stream()
                .map(supine -> {
                    return new SupineMapperImpl().supineToSupineDto(supine);
                })
                .collect(Collectors.toList());
    }
}
