package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ReviewofsymptomsDTO;
import com.PatManSystem.main.Models.Reviewofsymptoms;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReviewofsymptomsMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Reviewofsymptoms reviewofsymptomsDTOToReviewofsymptoms(ReviewofsymptomsDTO reviewofsymptomsDTO);

    @Mapping(source = "uli.id", target = "uliId")
    ReviewofsymptomsDTO reviewofsymptomsToReviewofsymptomsDTO(Reviewofsymptoms reviewofsymptoms);

    @Mapping(source = "uliId", target = "uli.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReviewofsymptomsFromReviewofsymptomsDTO(ReviewofsymptomsDTO reviewofsymptomsDTO, @MappingTarget Reviewofsymptoms reviewofsymptoms);
}
