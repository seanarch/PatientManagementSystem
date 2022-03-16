package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofsymptomDTO;
import com.PatManSystem.main.Mapper.TypeofsymptomMapperImpl;
import com.PatManSystem.main.Repository.TypeofsymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofsymptomService {

    @Autowired
    private TypeofsymptomRepository typeofsymptomRepository;

    public List<TypeofsymptomDTO> getTypeofsymptoms(){
        return typeofsymptomRepository.findAll()
                .stream()
                .map(typeofsymptom -> {
                    return new TypeofsymptomMapperImpl().typeofsymptomToTypeofsymptomDto(typeofsymptom);
                })
                .collect(Collectors.toList());
    }
}
