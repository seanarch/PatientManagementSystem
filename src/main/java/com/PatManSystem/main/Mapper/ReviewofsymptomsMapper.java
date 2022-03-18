package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.Models.Reviewofsymptoms;
import com.PatManSystem.main.DTO.ReviewofsymptomsDto;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReviewofsymptomsMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Reviewofsymptoms reviewofsymptomsDtoToReviewofsymptoms(ReviewofsymptomsDto reviewofsymptomsDto);

    ReviewofsymptomsDto reviewofsymptomsToReviewofsymptomsDto(Reviewofsymptoms reviewofsymptom);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiagnosisFromDiagnosisDto(ReviewofsymptomsDto reviewofsymptomsDto, @MappingTarget Reviewofsymptoms reviewofsymptom);
}
