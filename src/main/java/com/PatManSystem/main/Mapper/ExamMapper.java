package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Models.Exam;
import lombok.Builder;
import lombok.Builder.Default;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExamMapper {


    @Mapping(source = "abdoId", target = "abdo.id")
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
    Exam examDTOToExam(ExamDTO examDTO);

    @InheritInverseConfiguration(name = "examDTOToExam")
    ExamDTO examToExamDTO(Exam exam);

    @InheritConfiguration(name = "examDTOToExam")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateExamFromExamDTO(ExamDTO examDTO, @MappingTarget Exam exam);


}
