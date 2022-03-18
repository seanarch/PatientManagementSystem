package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.RadiationtherapyDto;
import com.PatManSystem.main.Models.Radiationtherapy;
import org.mapstruct.*;

public interface RadiationtherapyMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "typeRTId", target = "typeRT.id")
    @Mapping(source = "typeRTDescription", target = "typeRT.description")
    @Mapping(source = "locationId", target = "location.id")
    @Mapping(source = "planningId", target = "planning.id")
    @Mapping(source = "planningDescription", target = "planning.description")
    @Mapping(source = "pneumonitisId", target = "pneumonitis.id")
    @Mapping(source = "pneumonitisDescription", target = "pneumonitis.description")
    @Mapping(source = "upperGIId", target = "upperGI.id")
    @Mapping(source = "upperGIDescription", target = "upperGI.description")
    @Mapping(source = "skinReactionId", target = "skinReaction.id")
    @Mapping(source = "skinReactionDescription", target = "skinReaction.description")
    @Mapping(source = "lowerGIId", target = "lowerGI.id")
    @Mapping(source = "lowerGIDescription", target = "lowerGI.description")
    @Mapping(source = "guId", target = "gu.id")
    @Mapping(source = "guDescription", target = "gu.description")
    @Mapping(source = "hemeId", target = "heme.id")
    @Mapping(source = "hemeDescription", target = "heme.description")
    @Mapping(source = "hepaticId", target = "hepatic.id")
    @Mapping(source = "hepaticDescription", target = "hepatic.description")
    Radiationtherapy radiationtherapyDtoToRadiationtherapy(RadiationtherapyDto radiationtherapyDto);

    @InheritInverseConfiguration(name = "radiationtherapyDtoToRadiationtherapy")
    RadiationtherapyDto radiationtherapyToRadiationtherapyDto(Radiationtherapy radiationtherapy);

    @InheritConfiguration(name = "radiationtherapyToRadiationtherapy")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRadiationtherapyFromRadiationtherapyDto(RadiationtherapyDto radiationtherapyDto, @MappingTarget Radiationtherapy radiationtherapy);
}
