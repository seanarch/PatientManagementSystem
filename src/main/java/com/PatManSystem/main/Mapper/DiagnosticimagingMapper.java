package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.DiagnosticimagingDto;
import com.PatManSystem.main.Models.Diagnosticimaging;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DiagnosticimagingMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "typeDIId", target = "typeDI.id")
    @Mapping(source = "typeDIDescription", target = "typeDI.description")
    Diagnosticimaging diagnosticimagingDtoToDiagnosticimaging(DiagnosticimagingDto diagnosticimagingDto);

    @InheritInverseConfiguration(name = "diagnosticimagingDtoToDiagnosticimaging")
    DiagnosticimagingDto diagnosticimagingToDiagnosticimagingDto(Diagnosticimaging diagnosticimaging);

    @InheritConfiguration(name = "diagnosticimagingDtoToDiagnosticimaging")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiagnosticimagingFromDiagnosticimagingDto(DiagnosticimagingDto diagnosticimagingDto, @MappingTarget Diagnosticimaging diagnosticimaging);
}
