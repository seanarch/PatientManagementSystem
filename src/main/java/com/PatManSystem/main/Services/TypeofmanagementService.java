package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofmanagement;
import com.PatManSystem.main.Repository.TypeofmanagementRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeofmanagementService {


    private final TypeofmanagementRepository typeofmanagementRepository;

    @Autowired
    public TypeofmanagementService(TypeofmanagementRepository typeofmanagementRepository){
        this.typeofmanagementRepository = typeofmanagementRepository;
    }

    public List<Typeofmanagement> getTypeofmanagements(){
        return typeofmanagementRepository.findAll();
    }
    @SneakyThrows
    public Typeofmanagement getTypeofmanagement(Integer id){
        return typeofmanagementRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofmanagement identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofmanagement(Typeofmanagement entity){

        if (entity.getId() != null && typeofmanagementRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofmanagement identified by ID:{" + entity.getId() + "} already exists.");

        typeofmanagementRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofmanagement(Integer id){

        typeofmanagementRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofmanagement identified by id:{"+id+"} was not found."));
        typeofmanagementRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofmanagement(Typeofmanagement entity) {

        Typeofmanagement setEntity = typeofmanagementRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofmanagement identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        typeofmanagementRepository.save(setEntity);

    }
}
