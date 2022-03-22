package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.DecisionDTO;
import com.PatManSystem.main.Models.Decision;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DecisionMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "decisionId", target = "decision.id")
    @Mapping(source = "decisionDescription", target = "decision.description")
    Decision decisionDTOToDecision(DecisionDTO decisionDTO);

    @InheritInverseConfiguration(name = "decisionDTOToDecision")
    DecisionDTO decisionToDecisionDTO(Decision decision);

    @InheritConfiguration(name = "decisionDTOToDecision")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDecisionFromDecisionDTO(DecisionDTO decisionDTO, @MappingTarget Decision decision);
}
