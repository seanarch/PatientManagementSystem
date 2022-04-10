package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DeathDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
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
        return new DeathMapperImpl().deathToDeathDTO(deathRepository.findById(id).orElseThrow(() -> new NotFoundException("Death identified by ID:{"+id+"} was not found.")));
    }
    @SneakyThrows
    public List<DeathDTO> getByULI(Long ULI){

        List<Death> getDeaths = deathRepository.findByUli(new Patientinformation(ULI));

        if(getDeaths.isEmpty())
            throw new NotFoundException("Death identified by ID:{"+ULI+"} was not found.");

        return getDeaths.stream()
                .map(death -> new DeathMapperImpl().deathToDeathDTO(death))
                .collect(Collectors.toList());

    }
    @SneakyThrows
    public void newDeath(DeathDTO DTO){

        if(DTO.getId() != null && deathRepository.findById(DTO.getId()).isPresent())
            throw new DuplicateFoundException("Death identified by ID:{"+DTO.getId()+"} already exists.");

        deathRepository.save(new DeathMapperImpl().deathDTOToDeath(DTO)); // convert incoming DTO to DB entity and save to the DB

    }
    @SneakyThrows
    public void deleteDeath(Integer id){

        deathRepository.findById(id).orElseThrow(() -> new NotFoundException("Death identified by ID:{"+id+"} was not found."));
        deathRepository.deleteById(id);

    }
    @SneakyThrows
    public void updateDeath(DeathDTO DTO){

        Death setEntity = deathRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Death identified by ID:{"+DTO.getId()+"} was not found."));

        if (DTO.getDate() != null)
            setEntity.setDate(DTO.getDate());

        if (DTO.getDetail() != null)
            setEntity.setDetail(DTO.getDetail());

        deathRepository.save(setEntity);

    }
}
