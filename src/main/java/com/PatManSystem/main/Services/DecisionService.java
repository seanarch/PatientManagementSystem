package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DecisionDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.DecisionMapperImpl;
import com.PatManSystem.main.Models.Decision;
import com.PatManSystem.main.Models.Patientinformation;
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
        return new DecisionMapperImpl().decisionToDecisionDTO(decisionRepository.findById(id).orElseThrow(() -> new NotFoundException("Decision identified by ID:{"+id+"} was not found.")));
    }
    @SneakyThrows
    public List<DecisionDTO> getByULI(Long ULI){

        List<Decision> getDecisions = decisionRepository.findByUli(new Patientinformation(ULI));

        if(getDecisions.isEmpty())
            throw new NotFoundException("Decision identified by ID:{"+ULI+"} was not found.");

        return getDecisions.stream()
                .map(new DecisionMapperImpl()::decisionToDecisionDTO)
                .collect(Collectors.toList());

    }
    @SneakyThrows
    public void newDecision(DecisionDTO DTO){

        if(DTO.getId() != null && decisionRepository.findById(DTO.getId()).isPresent())
            throw new DuplicateFoundException("Decision identified by ID:{"+DTO.getId()+"} already exists.");

        decisionRepository.save(new DecisionMapperImpl().decisionDTOToDecision(DTO)); // convert incoming DTO to DB entity and save to the DB

    }
    @SneakyThrows
    public void deleteDecision(Integer id){

        decisionRepository.findById(id).orElseThrow(() -> new NotFoundException("Decision identified by ID:{"+id+"} was not found."));
        decisionRepository.deleteById(id);

    }
    @SneakyThrows
    public void updateDecision(DecisionDTO DTO){

        Decision setEntity = decisionRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Decision identified by ID:{"+DTO.getId()+"} was not found."));

        if (DTO.getDecisionId() != null)
            typeofdecisionRepository.findById(DTO.getDecisionId()).ifPresent(setEntity::setDecision);

        if (DTO.getDetail() != null)
            setEntity.setDetail(DTO.getDetail());

        decisionRepository.save(setEntity);

    }

}