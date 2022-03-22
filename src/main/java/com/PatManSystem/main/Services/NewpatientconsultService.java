package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.NewpatientconsultDTO;
import com.PatManSystem.main.Mapper.NewpatientconsultMapperImpl;
import com.PatManSystem.main.Repository.NewpatientconsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewpatientconsultService {

    @Autowired
    private NewpatientconsultRepository newpatientconsultRepository;

    public List<NewpatientconsultDTO> getNewpatientconsults(){
        return newpatientconsultRepository.findAll()
                .stream()
                .map(newpatientconsult -> {
                    return new NewpatientconsultMapperImpl().newpatientconsultToNewpatientconsultDTO(newpatientconsult);
                })
                .collect(Collectors.toList());
    }
}
