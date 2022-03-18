package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ConsiderDto;
import com.PatManSystem.main.Models.Consider;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConsiderMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "considerId", target = "consider.id")
    @Mapping(source = "considerDescription", target = "consider.description")
    Consider considerDtoToConsider(ConsiderDto considerDto);

    @InheritInverseConfiguration(name = "considerDtoToConsider")
    ConsiderDto considerToConsiderDto(Consider consider);

    @InheritConfiguration(name = "considerDtoToConsider")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateConsiderFromConsiderDto(ConsiderDto considerDto, @MappingTarget Consider consider);
}
