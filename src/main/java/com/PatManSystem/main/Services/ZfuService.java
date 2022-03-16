package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZfuDTO;
import com.PatManSystem.main.Mapper.ZfuMapperImpl;
import com.PatManSystem.main.Repository.ZfuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZfuService {

    @Autowired
    private ZfuRepository zfuRepository;

    public List<ZfuDTO> getZfus(){
        return zfuRepository.findAll()
                .stream()
                .map(zfu -> {
                    return new ZfuMapperImpl().zfuToZfuDto(zfu);
                })
                .collect(Collectors.toList());
    }
}
