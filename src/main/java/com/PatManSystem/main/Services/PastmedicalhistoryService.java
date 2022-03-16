package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.PastmedicalhistoryDTO;
import com.PatManSystem.main.Mapper.PastmedicalhistoryMapperImpl;
import com.PatManSystem.main.Repository.PastmedicalhistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PastmedicalhistoryService {

    @Autowired
    private PastmedicalhistoryRepository pastmedicalhistoryRepository;

    public List<PastmedicalhistoryDTO> getPastmedicalhistorys(){
        return pastmedicalhistoryRepository.findAll()
                .stream()
                .map(pastmedicalhistory -> {
                    return new PastmedicalhistoryMapperImpl().pastmedicalhistoryToPastmedicalhistoryDto(pastmedicalhistory);
                })
                .collect(Collectors.toList());
    }
}
