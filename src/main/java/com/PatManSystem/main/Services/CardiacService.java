package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.CardiacDTO;
import com.PatManSystem.main.Mapper.CardiacMapperImpl;
import com.PatManSystem.main.Repository.CardiacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardiacService {

    @Autowired
    private CardiacRepository cardiacRepository;

    public List<CardiacDTO> getCardiacs(){
        return cardiacRepository.findAll()
                .stream()
                .map(cardiac -> {
                    return new CardiacMapperImpl().cardiacToCardiacDto(cardiac);
                })
                .collect(Collectors.toList());
    }
}