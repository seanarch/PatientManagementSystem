package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.AssessDTO;
import com.PatManSystem.main.DTO.AssessDTO;
import com.PatManSystem.main.Mapper.AssessMapperImpl;
import com.PatManSystem.main.Mapper.AssessMapperImpl;
import com.PatManSystem.main.Models.Assess;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssessService {

    private final AssessRepository assessRepository;
    private final PatientRepository patientRepository;
    private final EcogperformancestatusscaleRepository ecogperformancestatusscaleRepository;
    private final MellowscoreRepository mellowscoreRepository;
    private final MrcdyspnoeascaleRepository mrcdyspnoeascaleRepository;

    @Autowired
    public AssessService(AssessRepository assessRepository,
                         PatientRepository patientRepository,
                         EcogperformancestatusscaleRepository ecogperformancestatusscaleRepository,
                         MellowscoreRepository mellowscoreRepository,
                         MrcdyspnoeascaleRepository mrcdyspnoeascaleRepository
                         ){
        this.assessRepository = assessRepository;
        this.patientRepository = patientRepository;
        this.ecogperformancestatusscaleRepository = ecogperformancestatusscaleRepository;
        this.mellowscoreRepository = mellowscoreRepository;
        this.mrcdyspnoeascaleRepository = mrcdyspnoeascaleRepository;
    }


    public List<AssessDTO> getAssesss(){
        return assessRepository.findAll()
        .stream()
        .map(assess -> new AssessMapperImpl().assessToAssessDTO(assess))
        .collect(Collectors.toList());
    }
    public AssessDTO getAssess(Integer id){
        Optional<Assess> getAssess = assessRepository.findById(id);
        if(getAssess.isEmpty()) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Assess identified by ID "+id+" was not found.");

        return new AssessMapperImpl().assessToAssessDTO(getAssess.get());

    }
    public List<AssessDTO> getAssessByULI(Long ULI){

        List<Assess> getAssesss = assessRepository.findAssessByUli(new Patientinformation(ULI,null,null,null,null,null,null,null));
        if(getAssesss == null) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Assess identified by ULI "+ULI+" was not found.");

        return getAssesss.stream()
                .map(assess -> new AssessMapperImpl().assessToAssessDTO(assess))
                .collect(Collectors.toList());

    }
    public void newAssess(AssessDTO assessDTO){

        if(assessRepository.findById(assessDTO.getId()).isPresent()){  //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Assess identified by ID "+assessDTO.getId() + " already exists. Use Post:Update at /api/patient/update instead.");
        }else{
            assessRepository.save(new AssessMapperImpl().assessDTOToAssess(assessDTO)); // convert incoming DTO to DB entity and save to the DB
        }

    }
    public void deleteAssess(Integer id){

        if(assessRepository.findById(id).isEmpty()){ //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Assess identified by ID "+id+ " does not exist.");
        }else{
            assessRepository.deleteById(id);
        }

    }
    public void updateAssess(AssessDTO DTO){
        Assess setEntity = assessRepository.findById(DTO.getId()).get(); //retrieve a copy of the entity type

        if(setEntity != null){

            if (DTO.getDate() != null)
                setEntity.setDate(DTO.getDate());

            if (DTO.getEcogId() != null)
                ecogperformancestatusscaleRepository.findById(DTO.getEcogId()).ifPresent(setEntity::setEcog);

            if (DTO.getSwallowingId() != null)
                mellowscoreRepository.findById(DTO.getSwallowingId()).ifPresent(setEntity::setSwallowing);

            if (DTO.getBreathingId() != null)
                mrcdyspnoeascaleRepository.findById(DTO.getBreathingId()).ifPresent(setEntity::setBreathing);

            assessRepository.save(setEntity);
        }else
            throw new IllegalStateException("Assess identified by ID "+DTO.getId()+ " does not exist.");
    }
}