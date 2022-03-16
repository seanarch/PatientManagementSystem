package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PtIdDto;
import com.PatManSystem.main.Models.Patientinformation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PtIdMapper {
    Patientinformation ptIdDtoToPtId(PtIdDto ptIdDto);

    PtIdDto ptIdToPtIdDto(Patientinformation patientinformation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePtIdFromPtIdDto(PtIdDto ptIdDto, @MappingTarget Patientinformation patientinformation);
}
