package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PatientinformationDto;
import com.PatManSystem.main.Models.Patientinformation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PatientinformationMapper {
    Patientinformation patientinformationDtoToPatientinformation(PatientinformationDto patientinformationDto);

    PatientinformationDto patientinformationToPatientinformationDto(Patientinformation patientinformation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePatientinformationFromPatientinformationDto(PatientinformationDto patientinformationDto, @MappingTarget Patientinformation patientinformation);
}
