package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZrtresponseDTO;
import com.PatManSystem.main.Mapper.ZrtresponseMapperImpl;
import com.PatManSystem.main.Repository.ZrtresponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZrtresponseService {

    @Autowired
    private ZrtresponseRepository zrtresponseRepository;

    public List<ZrtresponseDTO> getZrtresponses(){
        return zrtresponseRepository.findAll()
                .stream()
                .map(zrtresponse -> {
                    return new ZrtresponseMapperImpl().zrtresponseToZrtresponseDto(zrtresponse);
                })
                .collect(Collectors.toList());
    }
}
