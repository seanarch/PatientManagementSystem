package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PastmedicalhistoryDTO;
import com.PatManSystem.main.Models.Pastmedicalhistory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PastmedicalhistoryMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Pastmedicalhistory pastmedicalhistoryDTOToPastmedicalhistory(PastmedicalhistoryDTO pastmedicalhistoryDTO);

    @Mapping(source = "uli.id", target = "uliId")
    PastmedicalhistoryDTO pastmedicalhistoryToPastmedicalhistoryDTO(Pastmedicalhistory pastmedicalhistory);

    @Mapping(source = "uliId", target = "uli.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePastmedicalhistoryFromPastmedicalhistoryDTO(PastmedicalhistoryDTO pastmedicalhistoryDTO, @MappingTarget Pastmedicalhistory pastmedicalhistory);
}
