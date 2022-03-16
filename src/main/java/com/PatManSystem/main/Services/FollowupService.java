package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.FollowupDTO;
import com.PatManSystem.main.Mapper.FollowupMapperImpl;
import com.PatManSystem.main.Repository.FollowupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowupService {

    @Autowired
    private FollowupRepository followupRepository;

    public List<FollowupDTO> getFollowups(){
        return followupRepository.findAll()
                .stream()
                .map(followup -> {
                    return new FollowupMapperImpl().followupToFollowupDto(followup);
                })
                .collect(Collectors.toList());
    }
}
