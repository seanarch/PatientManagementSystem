package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.AssessDTO;
import com.PatManSystem.main.Models.Assess;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssessMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "ecogId", target = "ecog.id")
    @Mapping(source = "ecogDescription", target = "ecog.description")
    @Mapping(source = "swallowingId", target = "swallowing.id")
    @Mapping(source = "swallowingDescription", target = "swallowing.description")
    @Mapping(source = "breathingId", target = "breathing.id")
    @Mapping(source = "breathingDescription", target = "breathing.description")
    Assess assessDTOToAssess(AssessDTO assessDTO);

    @InheritInverseConfiguration(name = "assessDTOToAssess")
    AssessDTO assessToAssessDTO(Assess assess);

    @InheritConfiguration(name = "assessDTOToAssess")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAssessFromAssessDTO(AssessDTO assessDTO, @MappingTarget Assess assess);
}
