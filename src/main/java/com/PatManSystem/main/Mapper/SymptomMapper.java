package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.SymptomDTO;
import com.PatManSystem.main.Models.Symptom;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SymptomMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "symptomId", target = "symptom.id")
    @Mapping(source = "symptomDecription", target = "symptom.decription")
    Symptom symptomDTOToSymptom(SymptomDTO symptomDTO);

    @InheritInverseConfiguration(name = "symptomDTOToSymptom")
    SymptomDTO symptomToSymptomDTO(Symptom symptom);

    @InheritConfiguration(name = "symptomDTOToSymptom")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSymptomFromSymptomDTO(SymptomDTO symptomDTO, @MappingTarget Symptom symptom);
}
