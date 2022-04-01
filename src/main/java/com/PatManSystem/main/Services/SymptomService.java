package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.SymptomDTO;
import com.PatManSystem.main.DTO.SymptomDTO;
import com.PatManSystem.main.Mapper.SymptomMapperImpl;
import com.PatManSystem.main.Mapper.SymptomMapperImpl;
import com.PatManSystem.main.Models.Symptom;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Typeofsymptom;
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
        return new SymptomMapperImpl().symptomToSymptomDTO(symptomRepository.findById(id).orElseThrow(() -> new SymptomService.SymptomNotFound(id)));
    }

    @SneakyThrows
    public List<SymptomDTO> getByULI(Long ULI){

        List<Symptom> getSymptoms = symptomRepository.findByUli(new Patientinformation(ULI));

        if(getSymptoms.isEmpty())
            throw new SymptomService.SymptomNotFound(ULI);

        return getSymptoms.stream()
                .map(new SymptomMapperImpl()::symptomToSymptomDTO)
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public void newSymptom(SymptomDTO DTO){

        if(symptomRepository.findById(DTO.getId()).isPresent())
            throw new SymptomService.SymptomDuplicateFound(DTO.getId());

        symptomRepository.save(new SymptomMapperImpl().symptomDTOToSymptom(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteSymptom(Integer id){

        symptomRepository.findById(id).orElseThrow(() -> new SymptomService.SymptomNotFound(id));
        symptomRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateSymptom(SymptomDTO DTO){

        Symptom setEntity = symptomRepository.findById(DTO.getId()).orElseThrow(() -> new SymptomService.SymptomNotFound(DTO.getId()));

        if (DTO.getSymptomId() != null)
            typeofsymptomRepository.findById(DTO.getSymptomId()).ifPresent(setEntity::setSymptom);

        if (DTO.getDetail() != null)
            setEntity.setDetail(DTO.getDetail());

        symptomRepository.save(setEntity);

    }
    /* Custom exceptions for this class
     * NotFound
     * DuplicateFound
     */
    static class SymptomNotFound extends Exception{
        public SymptomNotFound(String errorMessage){
            super(errorMessage);
        }
        public SymptomNotFound(){
            super("Symptom not found");
        }
        public SymptomNotFound(Integer id){
            super("Symptom of ID:"+id+" not found");
        }
        public SymptomNotFound(Long ULI){
            super("Symptom of ULI:"+ULI+" not found");
        }
    }
    static class SymptomDuplicateFound extends Exception{
        public SymptomDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public SymptomDuplicateFound(){
            super("Symptom already exists");
        }
        public SymptomDuplicateFound(Integer id){
            super("Symptom of ID:"+id+" already exists");
        }
    }
}
