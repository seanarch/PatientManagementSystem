package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PatientinformationDTO;
import com.PatManSystem.main.Models.Patientinformation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PatientinformationMapper {
    Patientinformation patientinformationDTOToPatientinformation(PatientinformationDTO patientinformationDTO);

    PatientinformationDTO patientinformationToPatientinformationDTO(Patientinformation patientinformation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePatientinformationFromPatientinformationDTO(PatientinformationDTO patientinformationDTO, @MappingTarget Patientinformation patientinformation);
}
