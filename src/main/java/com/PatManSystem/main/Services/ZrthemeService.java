package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZrthemeDTO;
import com.PatManSystem.main.Mapper.ZrthemeMapperImpl;
import com.PatManSystem.main.Repository.ZrthemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZrthemeService {

    @Autowired
    private ZrthemeRepository zrthemeRepository;

    public List<ZrthemeDTO> getZrthemes(){
        return zrthemeRepository.findAll()
                .stream()
                .map(zrtheme -> {
                    return new ZrthemeMapperImpl().zrthemeToZrthemeDto(zrtheme);
                })
                .collect(Collectors.toList());
    }
}
