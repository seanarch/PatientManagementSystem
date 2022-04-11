package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofradiationtherapy;
import com.PatManSystem.main.Repository.TypeofradiationtherapyRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeofradiationtherapyService {


    private final TypeofradiationtherapyRepository typeofradiationtherapyRepository;

    @Autowired
    public TypeofradiationtherapyService(TypeofradiationtherapyRepository typeofradiationtherapyRepository){
        this.typeofradiationtherapyRepository = typeofradiationtherapyRepository;
    }

    public List<Typeofradiationtherapy> getTypeofradiationtherapys(){
        return typeofradiationtherapyRepository.findAll();
    }
    @SneakyThrows
    public Typeofradiationtherapy getTypeofradiationtherapy(Integer id){
        return typeofradiationtherapyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofradiationtherapy identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofradiationtherapy(Typeofradiationtherapy entity){

        if (entity.getId() != null && typeofradiationtherapyRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofradiationtherapy identified by ID:{" + entity.getId() + "} already exists.");

        typeofradiationtherapyRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofradiationtherapy(Integer id){

        typeofradiationtherapyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofradiationtherapy identified by id:{"+id+"} was not found."));
        typeofradiationtherapyRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofradiationtherapy(Typeofradiationtherapy entity) {

        Typeofradiationtherapy setEntity = typeofradiationtherapyRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofradiationtherapy identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        typeofradiationtherapyRepository.save(setEntity);

    }
}
