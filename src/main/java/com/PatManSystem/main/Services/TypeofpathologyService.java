package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofpathologyDTO;
import com.PatManSystem.main.Mapper.TypeofpathologyMapperImpl;
import com.PatManSystem.main.Repository.TypeofpathologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofpathologyService {

    @Autowired
    private TypeofpathologyRepository typeofpathologyRepository;

    public List<TypeofpathologyDTO> getTypeofpathologys(){
        return typeofpathologyRepository.findAll()
                .stream()
                .map(typeofpathology -> {
                    return new TypeofpathologyMapperImpl().typeofpathologyToTypeofpathologyDto(typeofpathology);
                })
                .collect(Collectors.toList());
    }
}
