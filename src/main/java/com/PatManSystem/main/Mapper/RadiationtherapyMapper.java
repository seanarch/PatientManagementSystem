package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.RadiationtherapyDTO;
import com.PatManSystem.main.Models.Radiationtherapy;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RadiationtherapyMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "typeRTId", target = "typeRT.id")
    @Mapping(source = "locationId", target = "location.id")
    @Mapping(source = "planningId", target = "planning.id")
    @Mapping(source = "pneumonitisId", target = "pneumonitis.id")
    @Mapping(source = "upperGIId", target = "upperGI.id")
    @Mapping(source = "skinReactionId", target = "skinReaction.id")
    @Mapping(source = "lowerGIId", target = "lowerGI.id")
    @Mapping(source = "guId", target = "gu.id")
    @Mapping(source = "hemeId", target = "heme.id")
    @Mapping(source = "hepaticId", target = "hepatic.id")
    Radiationtherapy radiationtherapyDTOToRadiationtherapy(RadiationtherapyDTO radiationtherapyDTO);

    @InheritInverseConfiguration(name = "radiationtherapyDTOToRadiationtherapy")
    RadiationtherapyDTO radiationtherapyToRadiationtherapyDTO(Radiationtherapy radiationtherapy);

    @InheritConfiguration(name = "radiationtherapyDTOToRadiationtherapy")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRadiationtherapyFromRadiationtherapyDTO(RadiationtherapyDTO radiationtherapyDTO, @MappingTarget Radiationtherapy radiationtherapy);
}
