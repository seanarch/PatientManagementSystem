package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.DiagnosisDto;
import com.PatManSystem.main.Models.Diagnosis;
import org.mapstruct.Mapping;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DiagnosisMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "locationId", target = "location.id")
    @Mapping(source = "orId", target = "or.id")
    @Mapping(source = "orDescription", target = "or.description")
    @Mapping(source = "pathologyId", target = "pathology.id")
    @Mapping(source = "pathologyDescription", target = "pathology.description")
    @Mapping(source = "recurId", target = "recur.id")
    @Mapping(source = "recurDescription", target = "recur.description")
    Diagnosis diagnosisDtoToDiagnosis(DiagnosisDto diagnosisDto);

    DiagnosisDto diagnosisToDiagnosisDto(Diagnosis diagnosis);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiagnosisFromDiagnosisDto(DiagnosisDto diagnosisDto, @MappingTarget Diagnosis diagnosis);
}
