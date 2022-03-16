package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofbiopsyDTO;
import com.PatManSystem.main.Mapper.TypeofbiopsyMapperImpl;
import com.PatManSystem.main.Repository.TypeofbiopsyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofbiopsyService {

    @Autowired
    private TypeofbiopsyRepository typeofbiopsyRepository;

    public List<TypeofbiopsyDTO> getTypeofbiopsys(){
        return typeofbiopsyRepository.findAll()
                .stream()
                .map(typeofbiopsy -> {
                    return new TypeofbiopsyMapperImpl().typeofbiopsyToTypeofbiopsyDto(typeofbiopsy);
                })
                .collect(Collectors.toList());
    }
}
