package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.MusculoskeletalDTO;
import com.PatManSystem.main.Mapper.MusculoskeletalMapperImpl;
import com.PatManSystem.main.Repository.MusculoskeletalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusculoskeletalService {

    @Autowired
    private MusculoskeletalRepository musculoskeletalRepository;

    public List<MusculoskeletalDTO> getMusculoskeletals(){
        return musculoskeletalRepository.findAll()
                .stream()
                .map(musculoskeletal -> {
                    return new MusculoskeletalMapperImpl().musculoskeletalToMusculoskeletalDto(musculoskeletal);
                })
                .collect(Collectors.toList());
    }
}
