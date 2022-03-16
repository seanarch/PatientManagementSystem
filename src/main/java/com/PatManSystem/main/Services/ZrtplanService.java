package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZrtplanDTO;
import com.PatManSystem.main.Mapper.ZrtplanMapperImpl;
import com.PatManSystem.main.Repository.ZrtplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZrtplanService {

    @Autowired
    private ZrtplanRepository zrtplanRepository;

    public List<ZrtplanDTO> getZrtplans(){
        return zrtplanRepository.findAll()
                .stream()
                .map(zrtplan -> {
                    return new ZrtplanMapperImpl().zrtplanToZrtplanDto(zrtplan);
                })
                .collect(Collectors.toList());
    }
}
