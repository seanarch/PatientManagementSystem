package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.TypeofhistoryofpresentillnessDTO;
import com.PatManSystem.main.Mapper.TypeofhistoryofpresentillnessMapperImpl;
import com.PatManSystem.main.Repository.TypeofhistoryofpresentillnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeofhistoryofpresentillnessService {

    @Autowired
    private TypeofhistoryofpresentillnessRepository typeofhistoryofpresentillnessRepository;

    public List<TypeofhistoryofpresentillnessDTO> getTypeofhistoryofpresentillnesss(){
        return typeofhistoryofpresentillnessRepository.findAll()
                .stream()
                .map(typeofhistoryofpresentillness -> {
                    return new TypeofhistoryofpresentillnessMapperImpl().typeofhistoryofpresentillnessToTypeofhistoryofpresentillnessDto(typeofhistoryofpresentillness);
                })
                .collect(Collectors.toList());
    }
}
