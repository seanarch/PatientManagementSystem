package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZrthepDTO;
import com.PatManSystem.main.Mapper.ZrthepMapperImpl;
import com.PatManSystem.main.Repository.ZrthepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZrthepService {

    @Autowired
    private ZrthepRepository zrthepRepository;

    public List<ZrthepDTO> getZrtheps(){
        return zrthepRepository.findAll()
                .stream()
                .map(zrthep -> {
                    return new ZrthepMapperImpl().zrthepToZrthepDto(zrthep);
                })
                .collect(Collectors.toList());
    }
}
