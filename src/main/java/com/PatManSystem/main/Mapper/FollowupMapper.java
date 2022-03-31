package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.FollowupDTO;
import com.PatManSystem.main.Models.Followup;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FollowupMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "typeFUId", target = "typeFU.id")
    @Mapping(source = "clinicalResponseId", target = "clinicalResponse.id")
    @Mapping(source = "pneumonitisId", target = "pneumonitis.id")
    @Mapping(source = "upperGIId", target = "upperGI.id")
    @Mapping(source = "skinReactionId", target = "skinReaction.id")
    @Mapping(source = "lowerGIId", target = "lowerGI.id")
    @Mapping(source = "guId", target = "gu.id")
    @Mapping(source = "hemeId", target = "heme.id")
    @Mapping(source = "hepaticId", target = "hepatic.id")
    Followup followupDTOToFollowup(FollowupDTO followupDTO);

    @InheritInverseConfiguration(name = "followupDTOToFollowup")
    FollowupDTO followupToFollowupDTO(Followup followup);

    @InheritConfiguration(name = "followupDTOToFollowup")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFollowupFromFollowupDTO(FollowupDTO followupDTO, @MappingTarget Followup followup);
}
