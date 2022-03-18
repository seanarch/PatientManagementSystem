package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PulmonaryfunctiontestDto;
import com.PatManSystem.main.Models.Pulmonaryfunctiontest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PulmonaryfunctiontestMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Pulmonaryfunctiontest pulmonaryfunctiontestDtoToPulmonaryfunctiontest(PulmonaryfunctiontestDto pulmonaryfunctiontestDto);

    @Mapping(source = "uli.id", target = "uliId")
    PulmonaryfunctiontestDto pulmonaryfunctiontestToPulmonaryfunctiontestDto(Pulmonaryfunctiontest pulmonaryfunctiontest);

    @Mapping(source = "uliId", target = "uli.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePulmonaryfunctiontestFromPulmonaryfunctiontestDto(PulmonaryfunctiontestDto pulmonaryfunctiontestDto, @MappingTarget Pulmonaryfunctiontest pulmonaryfunctiontest);
}
