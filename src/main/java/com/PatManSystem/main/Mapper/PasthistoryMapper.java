package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PasthistoryDto;
import com.PatManSystem.main.Models.Pasthistory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PasthistoryMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "GOCDesignationId", target = "GOCDesignation.id")
    Pasthistory pasthistoryDtoToPasthistory(PasthistoryDto pasthistoryDto);

    @InheritInverseConfiguration(name = "pasthistoryDtoToPasthistory")
    PasthistoryDto pasthistoryToPasthistoryDto(Pasthistory pasthistory);

    @InheritConfiguration(name = "pasthistoryDtoToPasthistory")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePasthistoryFromPasthistoryDto(PasthistoryDto pasthistoryDto, @MappingTarget Pasthistory pasthistory);
}
