package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZrtugiDTO;
import com.PatManSystem.main.Mapper.ZrtugiMapperImpl;
import com.PatManSystem.main.Repository.ZrtugiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZrtugiService {

    @Autowired
    private ZrtugiRepository zrtugiRepository;

    public List<ZrtugiDTO> getZrtugis(){
        return zrtugiRepository.findAll()
                .stream()
                .map(zrtugi -> {
                    return new ZrtugiMapperImpl().zrtugiToZrtugiDto(zrtugi);
                })
                .collect(Collectors.toList());
    }
}
