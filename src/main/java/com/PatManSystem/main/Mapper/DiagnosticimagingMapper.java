package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.DiagnosticimagingDTO;
import com.PatManSystem.main.Models.Diagnosticimaging;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DiagnosticimagingMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "typeDIId", target = "typeDI.id")
    @Mapping(source = "typeDIDescription", target = "typeDI.description")
    Diagnosticimaging diagnosticimagingDTOToDiagnosticimaging(DiagnosticimagingDTO diagnosticimagingDTO);

    @InheritInverseConfiguration(name = "diagnosticimagingDTOToDiagnosticimaging")
    DiagnosticimagingDTO diagnosticimagingToDiagnosticimagingDTO(Diagnosticimaging diagnosticimaging);

    @InheritConfiguration(name = "diagnosticimagingDTOToDiagnosticimaging")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiagnosticimagingFromDiagnosticimagingDTO(DiagnosticimagingDTO diagnosticimagingDTO, @MappingTarget Diagnosticimaging diagnosticimaging);
}
