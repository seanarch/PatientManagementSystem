package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DiagnosisDTO;
import com.PatManSystem.main.DTO.DiagnosisDTO;
import com.PatManSystem.main.Mapper.DiagnosisMapperImpl;
import com.PatManSystem.main.Mapper.DiagnosisMapperImpl;
import com.PatManSystem.main.Models.Diagnosis;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Typeofrecure;
import com.PatManSystem.main.Repository.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosisService {


    private final DiagnosisRepository diagnosisRepository;
    private final BodylocationRepository bodylocationRepository;
    private final TypeofbiopsyRepository typeofbiopsyRepository;
    private final TypeofpathologyRepository typeofpathologyRepository;
    private final TypeofrecureRepository typeofrecureRepository;

    @Autowired

    public DiagnosisService(DiagnosisRepository diagnosisRepository,
                            BodylocationRepository bodylocationRepository,
                            TypeofbiopsyRepository typeofbiopsyRepository,
                            TypeofpathologyRepository typeofpathologyRepository,
                            TypeofrecureRepository typeofrecureRepository){
        this.diagnosisRepository = diagnosisRepository;
        this.bodylocationRepository = bodylocationRepository;
        this.typeofbiopsyRepository = typeofbiopsyRepository;
        this.typeofpathologyRepository = typeofpathologyRepository;
        this.typeofrecureRepository = typeofrecureRepository;

    }


    public List<DiagnosisDTO> getDiagnosiss(){
        return diagnosisRepository.findAll()
                .stream()
                .map(new DiagnosisMapperImpl()::diagnosisToDiagnosisDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public DiagnosisDTO getDiagnosis(Integer id){
        return new DiagnosisMapperImpl().diagnosisToDiagnosisDTO(diagnosisRepository.findById(id).orElseThrow(() -> new DiagnosisService.DiagnosisNotFound(id)));
    }

    @SneakyThrows
    public List<DiagnosisDTO> getByULI(Long ULI){

        List<Diagnosis> getDiagnosiss = diagnosisRepository.findByUli(new Patientinformation(ULI));

        if(getDiagnosiss.isEmpty())
            throw new DiagnosisService.DiagnosisNotFound(ULI);

        return getDiagnosiss.stream()
                .map(new DiagnosisMapperImpl()::diagnosisToDiagnosisDTO)
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public void newDiagnosis(DiagnosisDTO DTO){

        if(diagnosisRepository.findById(DTO.getId()).isPresent())
            throw new DiagnosisService.DiagnosisDuplicateFound(DTO.getId());

        diagnosisRepository.save(new DiagnosisMapperImpl().diagnosisDTOToDiagnosis(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteDiagnosis(Integer id){

        diagnosisRepository.findById(id).orElseThrow(() -> new DiagnosisService.DiagnosisNotFound(id));
        diagnosisRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateDiagnosis(DiagnosisDTO DTO){

        Diagnosis setEntity = diagnosisRepository.findById(DTO.getId()).orElseThrow(() -> new DiagnosisService.DiagnosisNotFound(DTO.getId()));

        if (DTO.getNodesVe() != null)
            setEntity.setNodesVe(DTO.getNodesVe());

        if (DTO.getORDate() != null)
            setEntity.setORDate(DTO.getORDate());

        if (DTO.getLocationId() != null)
            bodylocationRepository.findById(DTO.getLocationId()).ifPresent(setEntity::setLocation);

        if (DTO.getOrId() != null)
            typeofbiopsyRepository.findById(DTO.getOrId()).ifPresent(setEntity::setOr);

        if (DTO.getSizePrimaryMm() != null)
            setEntity.setSizePrimaryMm(DTO.getSizePrimaryMm());

        if (DTO.getPathologyId() != null)
            typeofpathologyRepository.findById(DTO.getPathologyId()).ifPresent(setEntity::setPathology);

        if (DTO.getGrade() != null)
            setEntity.setGrade(DTO.getGrade());

        if (DTO.getMargin() != null)
            setEntity.setMargin(DTO.getMargin());

        if (DTO.getLvsi() != null)
            setEntity.setLvsi(DTO.getLvsi());

        if (DTO.getPeriNeural() != null)
            setEntity.setPeriNeural(DTO.getPeriNeural());

        if (DTO.getT() != null)
            setEntity.setT(DTO.getT());

        if (DTO.getNodesTaken() != null)
            setEntity.setNodesTaken(DTO.getNodesTaken());

        if (DTO.getN() != null)
            setEntity.setN(DTO.getN());

        if (DTO.getM() != null)
            setEntity.setM(DTO.getM());

        if (DTO.getStainingVeIHC() != null)
            setEntity.setStainingVeIHC(DTO.getStainingVeIHC());

        if (DTO.getStage() != null)
            setEntity.setStage(DTO.getStage());

        if (DTO.getRecurId() != null)
            typeofrecureRepository.findById(DTO.getRecurId()).ifPresent(setEntity::setRecur);

        if (DTO.getSiteOfFirstMet() != null)
            setEntity.setSiteOfFirstMet(DTO.getSiteOfFirstMet());

        if (DTO.getToday() != null)
            setEntity.setToday(DTO.getToday());

        diagnosisRepository.save(setEntity);

    }
    /* Custom exceptions for this class
     * NotFound
     * DuplicateFound
     */
    static class DiagnosisNotFound extends Exception{
        public DiagnosisNotFound(String errorMessage){
            super(errorMessage);
        }
        public DiagnosisNotFound(){
            super("Diagnosis not found");
        }
        public DiagnosisNotFound(Integer id){
            super("Diagnosis of ID:"+id+" not found");
        }
        public DiagnosisNotFound(Long ULI){
            super("Diagnosis of ULI:"+ULI+" not found");
        }
    }
    static class DiagnosisDuplicateFound extends Exception{
        public DiagnosisDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public DiagnosisDuplicateFound(){
            super("Diagnosis already exists");
        }
        public DiagnosisDuplicateFound(Integer id){
            super("Diagnosis of ID:"+id+" already exists");
        }
    }
}
