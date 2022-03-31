package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ChildpughDTO;
import com.PatManSystem.main.Models.Childpugh;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChildpughMapper {
    Childpugh childpughDTOToChildpugh(ChildpughDTO childpughDTO);

    ChildpughDTO childpughToChildpughDTO(Childpugh childpugh);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateChildpughFromChildpughDTO(ChildpughDTO childpughDTO, @MappingTarget Childpugh childpugh);
}
