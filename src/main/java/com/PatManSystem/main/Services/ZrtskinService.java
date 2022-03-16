package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ZrtskinDTO;
import com.PatManSystem.main.Mapper.ZrtskinMapperImpl;
import com.PatManSystem.main.Repository.ZrtskinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZrtskinService {

    @Autowired
    private ZrtskinRepository zrtskinRepository;

    public List<ZrtskinDTO> getZrtskins(){
        return zrtskinRepository.findAll()
                .stream()
                .map(zrtskin -> {
                    return new ZrtskinMapperImpl().zrtskinToZrtskinDto(zrtskin);
                })
                .collect(Collectors.toList());
    }
}
