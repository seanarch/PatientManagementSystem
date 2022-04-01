package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DeathDTO;
import com.PatManSystem.main.DTO.DeathDTO;
import com.PatManSystem.main.Mapper.DeathMapperImpl;
import com.PatManSystem.main.Mapper.DeathMapperImpl;
import com.PatManSystem.main.Models.Death;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.DeathRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeathService {

    private final DeathRepository deathRepository;
    
    @Autowired
    public DeathService(DeathRepository deathRepository){
        this.deathRepository = deathRepository;
    }

    public List<DeathDTO> getDeaths(){
        return deathRepository.findAll()
                .stream()
                .map(new DeathMapperImpl()::deathToDeathDTO)
                .collect(Collectors.toList());
    }
    @SneakyThrows
    public DeathDTO getDeath(Integer id){
        return new DeathMapperImpl().deathToDeathDTO(deathRepository.findById(id).orElseThrow(() -> new DeathService.DeathNotFound(id)));
    }
    @SneakyThrows
    public List<DeathDTO> getByULI(Long ULI){

        List<Death> getDeaths = deathRepository.findByUli(new Patientinformation(ULI));

        if(getDeaths.isEmpty())
            throw new DeathService.DeathNotFound(ULI);

        return getDeaths.stream()
                .map(death -> new DeathMapperImpl().deathToDeathDTO(death))
                .collect(Collectors.toList());

    }
    @SneakyThrows
    public void newDeath(DeathDTO DTO){

        if(deathRepository.findById(DTO.getId()).isPresent())
            throw new DeathService.DeathDuplicateFound(DTO.getId());

        deathRepository.save(new DeathMapperImpl().deathDTOToDeath(DTO)); // convert incoming DTO to DB entity and save to the DB

    }
    @SneakyThrows
    public void deleteDeath(Integer id){

        deathRepository.findById(id).orElseThrow(() -> new DeathService.DeathNotFound(id));
        deathRepository.deleteById(id);

    }
    @SneakyThrows
    public void updateDeath(DeathDTO DTO){

        Death setEntity = deathRepository.findById(DTO.getId()).orElseThrow(() -> new DeathService.DeathNotFound(DTO.getId()));

        if (DTO.getDate() != null)
            setEntity.setDate(DTO.getDate());

        if (DTO.getDetail() != null)
            setEntity.setDetail(DTO.getDetail());

        deathRepository.save(setEntity);

    }
    /* Custom exceptions for this class
     * NotFound
     * DuplicateFound
     */
    static class DeathNotFound extends Exception{
        public DeathNotFound(String errorMessage){
            super(errorMessage);
        }
        public DeathNotFound(){
            super("Death not found");
        }
        public DeathNotFound(Integer id){
            super("Death of ID:"+id+" not found");
        }
        public DeathNotFound(Long ULI){
            super("Death of ULI:"+ULI+" not found");
        }
    }
    static class DeathDuplicateFound extends Exception{
        public DeathDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public DeathDuplicateFound(){
            super("Death already exists");
        }
        public DeathDuplicateFound(Integer id){
            super("Death of ID:"+id+" already exists");
        }
    }
}
