package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofdecisionDTO;
import com.PatManSystem.main.Mapper.TypeofdecisionMapperImpl;
import com.PatManSystem.main.Repository.TypeofdecisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofdecisionService {

    @Autowired
    private TypeofdecisionRepository typeofdecisionRepository;

    public List<TypeofdecisionDTO> getTypeofdecisions(){
        return typeofdecisionRepository.findAll()
                .stream()
                .map(typeofdecision -> {
                    return new TypeofdecisionMapperImpl().typeofdecisionToTypeofdecisionDto(typeofdecision);
                })
                .collect(Collectors.toList());
    }
}
