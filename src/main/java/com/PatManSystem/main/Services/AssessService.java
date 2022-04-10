package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.AssessDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.AssessMapperImpl;
import com.PatManSystem.main.Models.Assess;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssessService {

    private final AssessRepository assessRepository;
    private final EcogperformancestatusscaleRepository ecogperformancestatusscaleRepository;
    private final MellowscoreRepository mellowscoreRepository;
    private final MrcdyspnoeascaleRepository mrcdyspnoeascaleRepository;

    @Autowired
    public AssessService(AssessRepository assessRepository,
                         EcogperformancestatusscaleRepository ecogperformancestatusscaleRepository,
                         MellowscoreRepository mellowscoreRepository,
                         MrcdyspnoeascaleRepository mrcdyspnoeascaleRepository
                         ){
        this.assessRepository = assessRepository;
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
    @SneakyThrows
    public AssessDTO getAssess(Integer id){
        return new AssessMapperImpl().assessToAssessDTO(assessRepository.findById(id).orElseThrow(() -> new NotFoundException("Assess identified by ID:{"+id+"} was not found.")));
    }
    @SneakyThrows
    public List<AssessDTO> getAssessByULI(Long ULI){

        List<Assess> getAssesss = assessRepository.findAssessByUli(new Patientinformation(ULI));

        if(getAssesss.isEmpty()) //check if the requested patient exists, if not; throw not found exception
            throw new NotFoundException("Assess identified by ULI:{"+ULI+"} was not found.");

        return getAssesss.stream()
                .map(assess -> new AssessMapperImpl().assessToAssessDTO(assess))
                .collect(Collectors.toList());

    }
    @SneakyThrows
    public void newAssess(AssessDTO assessDTO){

        if(assessDTO.getId() == null || assessRepository.findById(assessDTO.getId()).isEmpty())
            assessRepository.save(new AssessMapperImpl().assessDTOToAssess(assessDTO)); // convert incoming DTO to DB entity and save to the DB
        else
            throw new DuplicateFoundException("Assess identified by ID:{"+assessDTO.getId()+"} already exists.");

    }
    @SneakyThrows
    public void deleteAssess(Integer id){

        assessRepository.findById(id).orElseThrow(() -> new NotFoundException("Assess identified by ID:{"+id+"} was not found."));
        assessRepository.deleteById(id);

    }
    @SneakyThrows
    public void updateAssess(AssessDTO DTO){

        Assess setEntity = assessRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Assess identified by ID:{"+DTO.getId()+"} was not found."));

        if (DTO.getDate() != null)
            setEntity.setDate(DTO.getDate());

        if (DTO.getEcogId() != null)
            ecogperformancestatusscaleRepository.findById(DTO.getEcogId()).ifPresent(setEntity::setEcog);

        if (DTO.getSwallowingId() != null)
            mellowscoreRepository.findById(DTO.getSwallowingId()).ifPresent(setEntity::setSwallowing);

        if (DTO.getBreathingId() != null)
            mrcdyspnoeascaleRepository.findById(DTO.getBreathingId()).ifPresent(setEntity::setBreathing);

        assessRepository.save(setEntity);

    }
}