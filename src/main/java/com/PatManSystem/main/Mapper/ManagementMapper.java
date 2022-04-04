package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ManagementDTO;
import com.PatManSystem.main.Models.Management;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ManagementMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "interventionId", target = "intervention.id")
    @Mapping(source = "interventionDescription", target = "intervention.description")
    Management managementDTOToManagement(ManagementDTO managementDTO);

    @InheritInverseConfiguration(name = "managementDTOToManagement")
    ManagementDTO managementToManagementDTO(Management management);

    @InheritConfiguration(name = "managementDTOToManagement")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateManagementFromManagementDTO(ManagementDTO managementDTO, @MappingTarget Management management);
}
