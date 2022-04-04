package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ConsiderDTO;
import com.PatManSystem.main.Mapper.ConsiderMapperImpl;
import com.PatManSystem.main.Models.Consider;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.ConsiderRepository;
import com.PatManSystem.main.Repository.PatientRepository;
import com.PatManSystem.main.Repository.TypeofconsiderationRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsiderService {

    private final ConsiderRepository considerRepository;
    private final TypeofconsiderationRepository typeofconsiderationRepository;

    @Autowired
    public ConsiderService(ConsiderRepository considerRepository,
                           TypeofconsiderationRepository typeofconsiderationRepository){
        this.considerRepository = considerRepository;
        this.typeofconsiderationRepository = typeofconsiderationRepository;

    }

    public List<ConsiderDTO> getConsiders(){
        return considerRepository.findAll()
                .stream()
                .map(new ConsiderMapperImpl()::considerToConsiderDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public ConsiderDTO getConsider(Integer id){
        return new ConsiderMapperImpl().considerToConsiderDTO(considerRepository.findById(id).orElseThrow(() -> new ConsiderNotFound(id)));
    }

    @SneakyThrows
    public List<ConsiderDTO> getByULI(Long ULI){

        List<Consider> getConsiders = considerRepository.findByUli(new Patientinformation(ULI));

        if(getConsiders.isEmpty())
            throw new ConsiderNotFound(ULI);

        return getConsiders.stream()
                .map(new ConsiderMapperImpl()::considerToConsiderDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void newConsider(ConsiderDTO DTO){

        if(considerRepository.findById(DTO.getId()).isPresent())
            throw new ConsiderDuplicateFound(DTO.getId());

        considerRepository.save(new ConsiderMapperImpl().considerDTOToConsider(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteConsider(Integer id){

        considerRepository.findById(id).orElseThrow(() -> new ConsiderNotFound(id));
        considerRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateConsider(ConsiderDTO DTO){

        Consider setEntity = considerRepository.findById(DTO.getId()).orElseThrow(() -> new ConsiderNotFound(DTO.getId()));

        if (DTO.getConsiderId() != null)
            typeofconsiderationRepository.findById(DTO.getConsiderId()).ifPresent(setEntity::setConsider);

        if (DTO.getDetail() != null)
            setEntity.setDetail(DTO.getDetail());

        considerRepository.save(setEntity);

    }
    /* Custom exceptions for this class
     * NotFound
     * DuplicateFound
     */
    static class ConsiderNotFound extends Exception{
        public ConsiderNotFound(String errorMessage){
            super(errorMessage);
        }
        public ConsiderNotFound(){
            super("Consider not found");
        }
        public ConsiderNotFound(Integer id){
            super("Consider of ID:"+id+" not found");
        }
        public ConsiderNotFound(Long ULI){
            super("Consider of ULI:"+ULI+" not found");
        }
    }
    static class ConsiderDuplicateFound extends Exception{
        public ConsiderDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public ConsiderDuplicateFound(){
            super("Consider already exists");
        }
        public ConsiderDuplicateFound(Integer id){
            super("Consider of ID:"+id+" already exists");
        }
    }

}