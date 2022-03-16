package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.SkinDTO;
import com.PatManSystem.main.Mapper.SkinMapperImpl;
import com.PatManSystem.main.Repository.SkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkinService {

    @Autowired
    private SkinRepository skinRepository;

    public List<SkinDTO> getSkins(){
        return skinRepository.findAll()
                .stream()
                .map(skin -> {
                    return new SkinMapperImpl().skinToSkinDto(skin);
                })
                .collect(Collectors.toList());
    }
}
