package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PastmedicalhistoryDto;
import com.PatManSystem.main.Models.Pastmedicalhistory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PastmedicalhistoryMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Pastmedicalhistory pastmedicalhistoryDtoToPastmedicalhistory(PastmedicalhistoryDto pastmedicalhistoryDto);

    @Mapping(source = "uli.id", target = "uliId")
    PastmedicalhistoryDto pastmedicalhistoryToPastmedicalhistoryDto(Pastmedicalhistory pastmedicalhistory);

    @Mapping(source = "uliId", target = "uli.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePastmedicalhistoryFromPastmedicalhistoryDto(PastmedicalhistoryDto pastmedicalhistoryDto, @MappingTarget Pastmedicalhistory pastmedicalhistory);
}
