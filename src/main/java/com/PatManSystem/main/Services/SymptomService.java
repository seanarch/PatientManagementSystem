package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.SymptomDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.SymptomMapperImpl;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Symptom;
import com.PatManSystem.main.Repository.SymptomRepository;
import com.PatManSystem.main.Repository.TypeofsymptomRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService {
    
    
    private final SymptomRepository symptomRepository;
    private final TypeofsymptomRepository typeofsymptomRepository;


    @Autowired
    public SymptomService(SymptomRepository symptomRepository,  TypeofsymptomRepository typeofsymptomRepository){
        this.symptomRepository = symptomRepository;
        this.typeofsymptomRepository = typeofsymptomRepository;
    }
    

    public List<SymptomDTO> getSymptoms(){
        return symptomRepository.findAll()
                .stream()
                .map(new SymptomMapperImpl()::symptomToSymptomDTO)
                .collect(Collectors.toList());
    }
    @SneakyThrows
    public SymptomDTO getSymptom(Integer id){
        return new SymptomMapperImpl().symptomToSymptomDTO(symptomRepository.findById(id).orElseThrow(() -> new NotFoundException("Symptom identified by ULI:{" + id + "} does not exists.")));
    }

    @SneakyThrows
    public List<SymptomDTO> getByULI(Long ULI){

        List<Symptom> getSymptoms = symptomRepository.findByUli(new Patientinformation(ULI));

        if(getSymptoms.isEmpty())
            throw new NotFoundException("Symptom identified by ULI:{" + ULI + "} does not exists.");

        return getSymptoms.stream()
                .map(new SymptomMapperImpl()::symptomToSymptomDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void newSymptom(SymptomDTO DTO) {

        if (DTO.getId() != null && symptomRepository.findById(DTO.getId()).isPresent())
            throw new DuplicateFoundException("Symptom identified by ID:{" + DTO.getId() + "} already exists.");

        symptomRepository.save(new SymptomMapperImpl().symptomDTOToSymptom(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteSymptom(Integer id){

        symptomRepository.findById(id).orElseThrow(() -> new NotFoundException("Symptom identified by ID:{" + id + "} does not exists."));
        symptomRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateSymptom(SymptomDTO DTO){

        Symptom setEntity = symptomRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Symptom identified by ID:{" + DTO.getId() + "} does not exists."));

        if (DTO.getSymptomId() != null)
            typeofsymptomRepository.findById(DTO.getSymptomId()).ifPresent(setEntity::setSymptom);

        if (DTO.getDetail() != null)
            setEntity.setDetail(DTO.getDetail());

        symptomRepository.save(setEntity);

    }
}
