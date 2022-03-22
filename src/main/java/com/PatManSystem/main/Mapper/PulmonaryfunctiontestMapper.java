package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PulmonaryfunctiontestDTO;
import com.PatManSystem.main.Models.Pulmonaryfunctiontest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PulmonaryfunctiontestMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Pulmonaryfunctiontest pulmonaryfunctiontestDTOToPulmonaryfunctiontest(PulmonaryfunctiontestDTO pulmonaryfunctiontestDTO);

    @Mapping(source = "uli.id", target = "uliId")
    PulmonaryfunctiontestDTO pulmonaryfunctiontestToPulmonaryfunctiontestDTO(Pulmonaryfunctiontest pulmonaryfunctiontest);

    @Mapping(source = "uliId", target = "uli.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePulmonaryfunctiontestFromPulmonaryfunctiontestDTO(PulmonaryfunctiontestDTO pulmonaryfunctiontestDTO, @MappingTarget Pulmonaryfunctiontest pulmonaryfunctiontest);
}
