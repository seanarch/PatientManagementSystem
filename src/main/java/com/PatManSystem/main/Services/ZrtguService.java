package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZrtguDTO;
import com.PatManSystem.main.Mapper.ZrtguMapperImpl;
import com.PatManSystem.main.Repository.ZrtguRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZrtguService {

    @Autowired
    private ZrtguRepository zrtguRepository;

    public List<ZrtguDTO> getZrtgus(){
        return zrtguRepository.findAll()
                .stream()
                .map(zrtgu -> {
                    return new ZrtguMapperImpl().zrtguToZrtguDto(zrtgu);
                })
                .collect(Collectors.toList());
    }
}
