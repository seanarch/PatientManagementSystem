package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ChildpughDto;
import com.PatManSystem.main.Models.Childpugh;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChildpughMapper {
    Childpugh childpughDtoToChildpugh(ChildpughDto childpughDto);

    ChildpughDto childpughToChildpughDto(Childpugh childpugh);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateChildpughFromChildpughDto(ChildpughDto childpughDto, @MappingTarget Childpugh childpugh);
}
