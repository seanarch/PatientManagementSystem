package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.HistoryofpresentillnessDTO;
import com.PatManSystem.main.Models.Historyofpresentillness;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HistoryofpresentillnessMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "descriptorId", target = "descriptor.id")
    Historyofpresentillness historyofpresentillnessDTOToHistoryofpresentillness(HistoryofpresentillnessDTO historyofpresentillnessDTO);

    @InheritInverseConfiguration(name = "historyofpresentillnessDTOToHistoryofpresentillness")
    HistoryofpresentillnessDTO historyofpresentillnessToHistoryofpresentillnessDTO(Historyofpresentillness historyofpresentillness);

    @InheritConfiguration(name = "historyofpresentillnessDTOToHistoryofpresentillness")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateHistoryofpresentillnessFromHistoryofpresentillnessDTO(HistoryofpresentillnessDTO historyofpresentillnessDTO, @MappingTarget Historyofpresentillness historyofpresentillness);
}
