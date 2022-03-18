package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.HistoryofpresentillnessDto;
import com.PatManSystem.main.Models.Historyofpresentillness;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HistoryofpresentillnessMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "descriptorId", target = "descriptor.id")
    @Mapping(source = "descriptorDescription", target = "descriptor.description")
    Historyofpresentillness historyofpresentillnessDtoToHistoryofpresentillness(HistoryofpresentillnessDto historyofpresentillnessDto);

    @InheritInverseConfiguration(name = "historyofpresentillnessDtoToHistoryofpresentillness")
    HistoryofpresentillnessDto historyofpresentillnessToHistoryofpresentillnessDto(Historyofpresentillness historyofpresentillness);

    @InheritConfiguration(name = "historyofpresentillnessDtoToHistoryofpresentillness")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateHistoryofpresentillnessFromHistoryofpresentillnessDto(HistoryofpresentillnessDto historyofpresentillnessDto, @MappingTarget Historyofpresentillness historyofpresentillness);
}
