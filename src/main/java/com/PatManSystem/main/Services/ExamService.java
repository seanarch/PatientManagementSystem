package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.DTO.PatientinformationDTO;
import com.PatManSystem.main.Mapper.ExamMapperImpl;
import com.PatManSystem.main.Mapper.PatientinformationMapperImpl;
import com.PatManSystem.main.Models.Exam;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    @Autowired
    public ExamService(ExamRepository examRepository){
        this.examRepository = examRepository;
    }


    public List<ExamDTO> getExams(){
       return examRepository.findAll()
               .stream()
               .map(exam -> new ExamMapperImpl().examToExamDTO(exam))
               .collect(Collectors.toList());
    }

    public ExamDTO getExam(Long id){
        Exam getExam = examRepository.findExamById(id);
        if(getExam == null) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Exam identified by ID "+id+" was not found.");

        return new ExamMapperImpl().examToExamDTO(getExam);

    }
    public List<ExamDTO> getExamByULI(Long ULI){

        List<Exam> getExams = examRepository.findExamByUli(new Patientinformation(ULI,null,null,null,null,null,null,null));
        if(getExams == null) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Exam identified by ULI "+ULI+" was not found.");

        return getExams.stream()
                .map(exam -> new ExamMapperImpl().examToExamDTO(exam))
                .collect(Collectors.toList());

    }
    /*public void newExam(ExamDTO examDTO){

        if(examRepository.findExamById(examDTO.getId()) != null){  //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Patient identified by ULI "+examDTO.getId() + " already exists. Use Post:Update at /api/patient/update instead.");
        }else{
            examRepository.save(new PatientinformationMapperImpl().patientinformationDTOToPatientinformation(examDTO)); // convert incoming DTO to DB entity and save to the DB
        }

    }*/

}
