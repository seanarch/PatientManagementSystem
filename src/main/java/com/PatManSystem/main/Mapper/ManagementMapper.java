package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ManagementDto;
import com.PatManSystem.main.Models.Management;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ManagementMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "interventionId", target = "intervention.id")
    @Mapping(source = "interventionDescription", target = "intervention.description")
    Management managementDtoToManagement(ManagementDto managementDto);

    @InheritInverseConfiguration(name = "managementDtoToManagement")
    ManagementDto managementToManagementDto(Management management);

    @InheritConfiguration(name = "managementDtoToManagement")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateManagementFromManagementDto(ManagementDto managementDto, @MappingTarget Management management);
}
