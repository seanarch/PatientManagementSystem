package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZrtlgiDTO;
import com.PatManSystem.main.Mapper.ZrtlgiMapperImpl;
import com.PatManSystem.main.Repository.ZrtlgiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZrtlgiService {

    @Autowired
    private ZrtlgiRepository zrtlgiRepository;

    public List<ZrtlgiDTO> getZrtlgis(){
        return zrtlgiRepository.findAll()
                .stream()
                .map(zrtlgi -> {
                    return new ZrtlgiMapperImpl().zrtlgiToZrtlgiDto(zrtlgi);
                })
                .collect(Collectors.toList());
    }
}
