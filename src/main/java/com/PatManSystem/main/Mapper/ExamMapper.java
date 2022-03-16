package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Models.Exam;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExamMapper {
    @Mapping(source = "abdoId", target = "abdo.id")
    @Mapping(source = "abdoDescription", target = "abdo.description")
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "cnsId", target = "cns.id")
    @Mapping(source = "lungId", target = "lung.id")
    @Mapping(source = "hnId", target = "hn.id")
    @Mapping(source = "oralId", target = "oral.id")
    @Mapping(source = "cardiacId", target = "cardiac.id")
    @Mapping(source = "mskId", target = "msk.id")
    @Mapping(source = "peripheralId", target = "peripheral.id")
    @Mapping(source = "supineId", target = "supine.id")
    @Mapping(source = "breathId", target = "breath.id")
    Exam examDtoToExam(ExamDTO examDto);

    @InheritInverseConfiguration(name = "examDtoToExam")
    ExamDTO examToExamDto(Exam exam);

    @InheritConfiguration(name = "examDtoToExam")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateExamFromExamDto(ExamDTO examDto, @MappingTarget Exam exam);
}
