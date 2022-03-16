package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ChildpughDTO;
import com.PatManSystem.main.Mapper.ChildpughMapperImpl;
import com.PatManSystem.main.Repository.ChildpughRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildpughService {

    @Autowired
    private ChildpughRepository childpughRepository;

    public List<ChildpughDTO> getChildpughs(){
        return childpughRepository.findAll()
                .stream()
                .map(childpugh -> {
                    return new ChildpughMapperImpl().childpughToChildpughDto(childpugh);
                })
                .collect(Collectors.toList());
    }
}
