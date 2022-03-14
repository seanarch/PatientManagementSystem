package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.PtIdDto;
import com.PatManSystem.main.Models.PtId;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PtIdMapper {
    PtId ptIdDtoToPtId(PtIdDto ptIdDto);

    PtIdDto ptIdToPtIdDto(PtId ptId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePtIdFromPtIdDto(PtIdDto ptIdDto, @MappingTarget PtId ptId);
}
