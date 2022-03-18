package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ExamDto;
import com.PatManSystem.main.Models.Exam;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExamMapper {
    @Mapping(source = "abdoId", target = "abdo.id")
    @Mapping(source = "abdoDescription", target = "abdo.description")
    @Mapping(source = "uliId", target = "uli.id")
    @Mapping(source = "cnsId", target = "cns.id")
    @Mapping(source = "cnsDescription", target = "cns.description")
    @Mapping(source = "lungId", target = "lung.id")
    @Mapping(source = "lungDescription", target = "lung.description")
    @Mapping(source = "hnId", target = "hn.id")
    @Mapping(source = "hnDescription", target = "hn.description")
    @Mapping(source = "oralId", target = "oral.id")
    @Mapping(source = "oralDescription", target = "oral.description")
    @Mapping(source = "cardiacId", target = "cardiac.id")
    @Mapping(source = "cardiacDescription", target = "cardiac.description")
    @Mapping(source = "mskId", target = "msk.id")
    @Mapping(source = "mskDescription", target = "msk.description")
    @Mapping(source = "peripheralId", target = "peripheral.id")
    @Mapping(source = "peripheralDescription", target = "peripheral.description")
    @Mapping(source = "supineId", target = "supine.id")
    @Mapping(source = "supineDescription", target = "supine.description")
    @Mapping(source = "breathId", target = "breath.id")
    @Mapping(source = "breathDescription", target = "breath.description")
    Exam examDtoToExam(ExamDto examDto);

    @InheritInverseConfiguration(name = "examDtoToExam")
    ExamDto examToExamDto(Exam exam);

    @InheritConfiguration(name = "examDtoToExam")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateExamFromExamDto(ExamDto examDto, @MappingTarget Exam exam);
}
