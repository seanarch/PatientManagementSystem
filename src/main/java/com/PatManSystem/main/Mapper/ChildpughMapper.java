package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ChildpughDTO;
import com.PatManSystem.main.Models.Childpugh;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChildpughMapper {
    @Mapping(source = "uliId", target = "uli.id")
    Childpugh childpughDTOToChildpugh(ChildpughDTO childpughDTO);

    @InheritInverseConfiguration(name = "childDTOToChildpugh")
    ChildpughDTO childpughToChildpughDTO(Childpugh childpugh);

    @InheritConfiguration(name = "childpughDTOToChildpugh")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateChildpughFromChildpughDTO(ChildpughDTO childpughDTO, @MappingTarget Childpugh childpugh);
}
