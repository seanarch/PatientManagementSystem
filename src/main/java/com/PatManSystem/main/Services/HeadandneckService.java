package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.HeadandneckDTO;
import com.PatManSystem.main.Mapper.HeadandneckMapperImpl;
import com.PatManSystem.main.Repository.HeadandneckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeadandneckService {

    @Autowired
    private HeadandneckRepository headandneckRepository;

    public List<HeadandneckDTO> getHeadandnecks(){
        return headandneckRepository.findAll()
                .stream()
                .map(headandneck -> {
                    return new HeadandneckMapperImpl().headandneckToHeadandneckDto(headandneck);
                })
                .collect(Collectors.toList());
    }
}
