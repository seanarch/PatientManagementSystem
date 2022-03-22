package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ReviewofsymptomsDTO;
import com.PatManSystem.main.Mapper.ReviewofsymptomsMapperImpl;
import com.PatManSystem.main.Repository.ReviewofsymptomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewofsymptomsService {

    @Autowired
    private ReviewofsymptomsRepository reviewofsymptomsRepository;

    public List<ReviewofsymptomsDTO> getReviewofsymptomss(){
        return reviewofsymptomsRepository.findAll()
                .stream()
                .map(reviewofsymptoms -> {
                    return new ReviewofsymptomsMapperImpl().reviewofsymptomsToReviewofsymptomsDTO(reviewofsymptoms);
                })
                .collect(Collectors.toList());
    }
}
