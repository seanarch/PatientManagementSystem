package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PatientinformationDTO;
import com.PatManSystem.main.Models.Patientinformation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PtIdMapper {
    Patientinformation ptIdDtoToPtId(PatientinformationDTO patientinformationDTO);

    PatientinformationDTO ptIdToPtIdDto(Patientinformation patientinformation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePtIdFromPtIdDto(PatientinformationDTO patientinformationDTO, @MappingTarget Patientinformation patientinformation);
}
