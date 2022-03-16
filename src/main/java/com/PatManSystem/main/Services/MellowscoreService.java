package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.MellowscoreDTO;
import com.PatManSystem.main.Mapper.MellowscoreMapperImpl;
import com.PatManSystem.main.Repository.MellowscoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MellowscoreService {

    @Autowired
    private MellowscoreRepository mellowscoreRepository;

    public List<MellowscoreDTO> getMellowscores(){
        return mellowscoreRepository.findAll()
                .stream()
                .map(mellowscore -> {
                    return new MellowscoreMapperImpl().mellowscoreToMellowscoreDto(mellowscore);
                })
                .collect(Collectors.toList());
    }
}
