package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.AbdomenDTO;
import com.PatManSystem.main.Mapper.AbdomenMapperImpl;
import com.PatManSystem.main.Repository.AbdomenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbdomenService {

    @Autowired
    private AbdomenRepository abdomenRepository;

    public List<AbdomenDTO> getAbdomens(){
        return abdomenRepository.findAll()
                .stream()
                .map(abdomen -> {
                    return new AbdomenMapperImpl().abdomenToAbdomenDto(abdomen);
                })
                .collect(Collectors.toList());
    }
}
