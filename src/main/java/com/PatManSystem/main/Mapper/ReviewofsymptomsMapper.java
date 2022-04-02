package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.Models.Reviewofsymptoms;
import com.PatManSystem.main.DTO.ReviewofsymptomsDTO;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReviewofsymptomsMapper {

    @Mapping(source = "uliId", target = "uli.id")
    Reviewofsymptoms reviewofsymptomsDTOToReviewofsymptoms(ReviewofsymptomsDTO reviewofsymptomsDTO);

    ReviewofsymptomsDTO reviewofsymptomsToReviewofsymptomsDTO(Reviewofsymptoms reviewofsymptom);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiagnosisFromDiagnosisDTO(ReviewofsymptomsDTO reviewofsymptomsDTO, @MappingTarget Reviewofsymptoms reviewofsymptom);
}
