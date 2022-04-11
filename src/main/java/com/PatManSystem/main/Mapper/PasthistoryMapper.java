package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PasthistoryDTO;
import com.PatManSystem.main.Models.Pasthistory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PasthistoryMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "goalofcareId", target = "goalofcare.id")
    Pasthistory pasthistoryDTOToPasthistory(PasthistoryDTO pasthistoryDTO);

    @InheritInverseConfiguration(name = "pasthistoryDTOToPasthistory")
    PasthistoryDTO pasthistoryToPasthistoryDTO(Pasthistory pasthistory);

    @InheritConfiguration(name = "pasthistoryDTOToPasthistory")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePasthistoryFromPasthistoryDTO(PasthistoryDTO pasthistoryDTO, @MappingTarget Pasthistory pasthistory);
}
