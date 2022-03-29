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

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    public void newExam(ExamDTO examDTO){

        if(examRepository.findExamById(examDTO.getId()) != null){  //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Exam identified by ID "+examDTO.getId() + " already exists. Use Post:Update at /api/patient/update instead.");
        }else{
            examRepository.save(new ExamMapperImpl().examDTOToExam(examDTO)); // convert incoming DTO to DB entity and save to the DB
        }

    }
    public void deleteExam(Long id){

        if(examRepository.findExamById(id) == null){ //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Exam identified by ID "+id+ " does not exist.");
        }else{
            examRepository.deleteById(id);
        }

    }
    @Transactional // set all methods to be transactional, when a .set is called, it will create a DB transaction of the same type
    public void updateExam(ExamDTO DTO){
        /*
            The following code is really hard to explain. Basically it dynamically maps the getters from the DTO
            to the setters of the DB entity. Using this technique this code is model agnostic and doesnt need to
            be modified for new models. To use this in other Service classes you need only change the repository
            type, and the DTO type. Specifically the Class type of entity and DTO
        */

        Exam entity = examRepository.findExamById(DTO.getId()); //retrieve a copy of the Patientinfo
        if(entity != null)
        for (Method getter : DTO.getClass().getMethods()) {
            Object get = "";
            if (getter.getName().startsWith("get") && getter.getParameterTypes().length == 0) {
                try {
                    get = getter.invoke(DTO);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (get != null)
                    for (Method setter : entity.getClass().getMethods()) {
                        if (setter.getName().startsWith("set") && setter.getName().endsWith(getter.getName().substring(3)) && setter.getParameterTypes().length == 1) {
                            try {
                                setter.invoke(entity, get);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                            continue;
                        }
                    }
            }
        }
        else
            throw new IllegalStateException("Exam identified by ID "+DTO.getId()+ " does not exist.");
    }

}
