package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.FollowupDTO;
import com.PatManSystem.main.Models.Followup;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FollowupMapper {
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "typeFUId", target = "typeFU.id")
    @Mapping(source = "typeFUDescription", target = "typeFU.description")
    @Mapping(source = "clinicalResponseId", target = "clinicalResponse.id")
    @Mapping(source = "clinicalResponseDescription", target = "clinicalResponse.description")
    @Mapping(source = "pneumonitisId", target = "pneumonitis.id")
    @Mapping(source = "pneumonitisDescription", target = "pneumonitis.description")
    @Mapping(source = "upperGIId", target = "upperGI.id")
    @Mapping(source = "upperGIDescription", target = "upperGI.description")
    @Mapping(source = "skinReactionId", target = "skinReaction.id")
    @Mapping(source = "skinReactionDescription", target = "skinReaction.description")
    @Mapping(source = "lowerGIId", target = "lowerGI.id")
    @Mapping(source = "lowerGIDescription", target = "lowerGI.description")
    @Mapping(source = "guId", target = "gu.id")
    @Mapping(source = "guDescription", target = "gu.description")
    @Mapping(source = "hemeId", target = "heme.id")
    @Mapping(source = "hemeDescription", target = "heme.description")
    @Mapping(source = "hepaticId", target = "hepatic.id")
    @Mapping(source = "hepaticDescription", target = "hepatic.description")
    Followup followupDTOToFollowup(FollowupDTO followupDTO);

    @InheritInverseConfiguration(name = "followupDTOToFollowup")
    FollowupDTO followupToFollowupDTO(Followup followup);

    @InheritConfiguration(name = "followupDTOToFollowup")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFollowupFromFollowupDTO(FollowupDTO followupDTO, @MappingTarget Followup followup);
}
