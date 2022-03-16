package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofconsiderationDTO;
import com.PatManSystem.main.Mapper.TypeofconsiderationMapperImpl;
import com.PatManSystem.main.Repository.TypeofconsiderationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofconsiderationService {

    @Autowired
    private TypeofconsiderationRepository typeofconsiderationRepository;

    public List<TypeofconsiderationDTO> getTypeofconsiderations(){
        return typeofconsiderationRepository.findAll()
                .stream()
                .map(typeofconsideration -> {
                    return new TypeofconsiderationMapperImpl().typeofconsiderationToTypeofconsiderationDto(typeofconsideration);
                })
                .collect(Collectors.toList());
    }
}
