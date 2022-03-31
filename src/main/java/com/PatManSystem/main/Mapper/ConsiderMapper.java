package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ConsiderDTO;
import com.PatManSystem.main.Models.Consider;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConsiderMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "considerId", target = "consider.id")
    @Mapping(source = "considerDescription", target = "consider.description")
    Consider considerDTOToConsider(ConsiderDTO considerDTO);

    @InheritInverseConfiguration(name = "considerDTOToConsider")
    ConsiderDTO considerToConsiderDTO(Consider consider);

    @InheritConfiguration(name = "considerDTOToConsider")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateConsiderFromConsiderDTO(ConsiderDTO considerDTO, @MappingTarget Consider consider);
}
