package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.HistoryofpresentillnessDTO;
import com.PatManSystem.main.Mapper.HistoryofpresentillnessMapperImpl;
import com.PatManSystem.main.Repository.HistoryofpresentillnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryofpresentillnessService {

    @Autowired
    private HistoryofpresentillnessRepository historyofpresentillnessRepository;

    public List<HistoryofpresentillnessDTO> getHistoryofpresentillnesss(){
        return historyofpresentillnessRepository.findAll()
                .stream()
                .map(historyofpresentillness -> {
                    return new HistoryofpresentillnessMapperImpl().historyofpresentillnessToHistoryofpresentillnessDto(historyofpresentillness);
                })
                .collect(Collectors.toList());
    }
}
