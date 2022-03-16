package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.MrcdyspnoeascaleDTO;
import com.PatManSystem.main.Mapper.MrcdyspnoeascaleMapperImpl;
import com.PatManSystem.main.Repository.MrcdyspnoeascaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MrcdyspnoeascaleService {

    @Autowired
    private MrcdyspnoeascaleRepository mrcdyspnoeascaleRepository;

    public List<MrcdyspnoeascaleDTO> getMrcdyspnoeascales(){
        return mrcdyspnoeascaleRepository.findAll()
                .stream()
                .map(mrcdyspnoeascale -> {
                    return new MrcdyspnoeascaleMapperImpl().mrcdyspnoeascaleToMrcdyspnoeascaleDto(mrcdyspnoeascale);
                })
                .collect(Collectors.toList());
    }
}
