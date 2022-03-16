package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.PasthistoryDTO;
import com.PatManSystem.main.Mapper.PasthistoryMapperImpl;
import com.PatManSystem.main.Repository.PasthistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasthistoryService {

    @Autowired
    private PasthistoryRepository pasthistoryRepository;

    public List<PasthistoryDTO> getPasthistorys(){
        return pasthistoryRepository.findAll()
                .stream()
                .map(pasthistory -> {
                    return new PasthistoryMapperImpl().pasthistoryToPasthistoryDto(pasthistory);
                })
                .collect(Collectors.toList());
    }
}
