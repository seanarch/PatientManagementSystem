package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZrtlungDTO;
import com.PatManSystem.main.Mapper.ZrtlungMapperImpl;
import com.PatManSystem.main.Repository.ZrtlungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZrtlungService {

    @Autowired
    private ZrtlungRepository zrtlungRepository;

    public List<ZrtlungDTO> getZrtlungs(){
        return zrtlungRepository.findAll()
                .stream()
                .map(zrtlung -> {
                    return new ZrtlungMapperImpl().zrtlungToZrtlungDto(zrtlung);
                })
                .collect(Collectors.toList());
    }
}
