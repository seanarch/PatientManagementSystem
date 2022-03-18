package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.SymptomDto;
import com.PatManSystem.main.Models.Symptom;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SymptomMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "symptomId", target = "symptom.id")
    @Mapping(source = "symptomDecription", target = "symptom.decription")
    Symptom symptomDtoToSymptom(SymptomDto symptomDto);

    @InheritInverseConfiguration(name = "symptomDtoToSymptom")
    SymptomDto symptomToSymptomDto(Symptom symptom);

    @InheritConfiguration(name = "symptomDtoToSymptom")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSymptomFromSymptomDto(SymptomDto symptomDto, @MappingTarget Symptom symptom);
}
