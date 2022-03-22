package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.DeathDTO;
import com.PatManSystem.main.Models.Death;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DeathMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Death deathDTOToDeath(DeathDTO deathDTO);

    @Mapping(source = "uli.id", target = "uliId")
    DeathDTO deathToDeathDTO(Death death);

    @Mapping(source = "uliId", target = "uli.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDeathFromDeathDTO(DeathDTO deathDTO, @MappingTarget Death death);
}
