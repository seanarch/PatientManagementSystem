package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.DiagnosisDTO;
import com.PatManSystem.main.Models.Diagnosis;
import org.mapstruct.Mapping;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DiagnosisMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "locationId", target = "location.id")
    @Mapping(source = "orId", target = "or.id")
    @Mapping(source = "pathologyId", target = "pathology.id")
    @Mapping(source = "recurId", target = "recur.id")
    Diagnosis diagnosisDTOToDiagnosis(DiagnosisDTO diagnosisDTO);

    @InheritInverseConfiguration(name = "diagnosisDTOToDiagnosis")
    DiagnosisDTO diagnosisToDiagnosisDTO(Diagnosis diagnosis);

    @InheritConfiguration(name = "diagnosisDTOToDiagnosis")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiagnosisFromDiagnosisDTO(DiagnosisDTO diagnosisDTO, @MappingTarget Diagnosis diagnosis);
}
