package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofrecureDTO;
import com.PatManSystem.main.Mapper.TypeofrecureMapperImpl;
import com.PatManSystem.main.Repository.TypeofrecureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofrecureService {

    @Autowired
    private TypeofrecureRepository typeofrecureRepository;

    public List<TypeofrecureDTO> getTypeofrecures(){
        return typeofrecureRepository.findAll()
                .stream()
                .map(typeofrecure -> {
                    return new TypeofrecureMapperImpl().typeofrecureToTypeofrecureDto(typeofrecure);
                })
                .collect(Collectors.toList());
    }
}
