package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.DeathDto;
import com.PatManSystem.main.Models.Death;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DeathMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Death deathDtoToDeath(DeathDto deathDto);

    @Mapping(source = "uli.id", target = "uliId")
    DeathDto deathToDeathDto(Death death);

    @Mapping(source = "uliId", target = "uli.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDeathFromDeathDto(DeathDto deathDto, @MappingTarget Death death);
}
