package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DecisionDTO;
import com.PatManSystem.main.DTO.DecisionDTO;
import com.PatManSystem.main.Mapper.DecisionMapperImpl;
import com.PatManSystem.main.Mapper.DecisionMapperImpl;
import com.PatManSystem.main.Models.Decision;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Typeofdecision;
import com.PatManSystem.main.Repository.DecisionRepository;
import com.PatManSystem.main.Repository.TypeofdecisionRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DecisionService {

    private final DecisionRepository decisionRepository;
    private final TypeofdecisionRepository typeofdecisionRepository;

    @Autowired
    public DecisionService(DecisionRepository decisionRepository, TypeofdecisionRepository typeofdecisionRepository){
        this.decisionRepository = decisionRepository;
        this.typeofdecisionRepository = typeofdecisionRepository;
    }

    public List<DecisionDTO> getDecisions(){
        return decisionRepository.findAll()
                .stream()
                .map(decision -> new DecisionMapperImpl().decisionToDecisionDTO(decision))
                .collect(Collectors.toList());
    }
    @SneakyThrows
    public DecisionDTO getDecision(Integer id){
        return new DecisionMapperImpl().decisionToDecisionDTO(decisionRepository.findById(id).orElseThrow(() -> new DecisionService.DecisionNotFound(id)));
    }
    @SneakyThrows
    public List<DecisionDTO> getByULI(Long ULI){

        List<Decision> getDecisions = decisionRepository.findByUli(new Patientinformation(ULI));

        if(getDecisions.isEmpty())
            throw new DecisionService.DecisionNotFound(ULI);

        return getDecisions.stream()
                .map(new DecisionMapperImpl()::decisionToDecisionDTO)
                .collect(Collectors.toList());

    }
    @SneakyThrows
    public void newDecision(DecisionDTO DTO){

        if(decisionRepository.findById(DTO.getId()).isPresent())
            throw new DecisionService.DecisionDuplicateFound(DTO.getId());

        decisionRepository.save(new DecisionMapperImpl().decisionDTOToDecision(DTO)); // convert incoming DTO to DB entity and save to the DB

    }
    @SneakyThrows
    public void deleteDecision(Integer id){

        decisionRepository.findById(id).orElseThrow(() -> new DecisionService.DecisionNotFound(id));
        decisionRepository.deleteById(id);

    }
    @SneakyThrows
    public void updateDecision(DecisionDTO DTO){

        Decision setEntity = decisionRepository.findById(DTO.getId()).orElseThrow(() -> new DecisionService.DecisionNotFound(DTO.getId()));

        if (DTO.getDecisionId() != null)
            typeofdecisionRepository.findById(DTO.getDecisionId()).ifPresent(setEntity::setDecision);

        if (DTO.getDetail() != null)
            setEntity.setDetail(DTO.getDetail());

        decisionRepository.save(setEntity);

    }
    /* Custom exceptions for this class
     * NotFound
     * DuplicateFound
     */
    static class DecisionNotFound extends Exception{
        public DecisionNotFound(String errorMessage){
            super(errorMessage);
        }
        public DecisionNotFound(){
            super("Decision not found");
        }
        public DecisionNotFound(Integer id){
            super("Decision of ID:"+id+" not found");
        }
        public DecisionNotFound(Long ULI){
            super("Decision of ULI:"+ULI+" not found");
        }
    }
    static class DecisionDuplicateFound extends Exception{
        public DecisionDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public DecisionDuplicateFound(){
            super("Decision already exists");
        }
        public DecisionDuplicateFound(Integer id){
            super("Decision of ID:"+id+" already exists");
        }
    }

}