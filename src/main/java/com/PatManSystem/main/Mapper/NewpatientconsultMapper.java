package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.NewpatientconsultDTO;
import com.PatManSystem.main.Models.Newpatientconsult;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NewpatientconsultMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Newpatientconsult newpatientconsultDTOToNewpatientconsult(NewpatientconsultDTO newpatientconsultDTO);

    @Mapping(source = "uli.id", target = "uliId")
    NewpatientconsultDTO newpatientconsultToNewpatientconsultDTO(Newpatientconsult newpatientconsult);

    @Mapping(source = "uliId", target = "uli.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNewpatientconsultFromNewpatientconsultDTO(NewpatientconsultDTO newpatientconsultDTO, @MappingTarget Newpatientconsult newpatientconsult);
}
