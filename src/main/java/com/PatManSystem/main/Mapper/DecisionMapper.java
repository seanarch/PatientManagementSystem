package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.DecisionDto;
import com.PatManSystem.main.Models.Decision;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DecisionMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "decisionId", target = "decision.id")
    @Mapping(source = "decisionDescription", target = "decision.description")
    Decision decisionDtoToDecision(DecisionDto decisionDto);

    @InheritInverseConfiguration(name = "decisionDtoToDecision")
    DecisionDto decisionToDecisionDto(Decision decision);

    @InheritConfiguration(name = "decisionDtoToDecision")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDecisionFromDecisionDto(DecisionDto decisionDto, @MappingTarget Decision decision);
}
