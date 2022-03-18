package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.NewpatientconsultDto;
import com.PatManSystem.main.Models.Newpatientconsult;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NewpatientconsultMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Newpatientconsult newpatientconsultDtoToNewpatientconsult(NewpatientconsultDto newpatientconsultDto);

    @Mapping(source = "uli.id", target = "uliId")
    NewpatientconsultDto newpatientconsultToNewpatientconsultDto(Newpatientconsult newpatientconsult);

    @Mapping(source = "uliId", target = "uli.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNewpatientconsultFromNewpatientconsultDto(NewpatientconsultDto newpatientconsultDto, @MappingTarget Newpatientconsult newpatientconsult);
}
