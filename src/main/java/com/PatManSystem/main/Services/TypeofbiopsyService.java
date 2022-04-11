package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofbiopsy;
import com.PatManSystem.main.Repository.TypeofbiopsyRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeofbiopsyService {


    private final TypeofbiopsyRepository typeofbiopsyRepository;

    @Autowired
    public TypeofbiopsyService(TypeofbiopsyRepository typeofbiopsyRepository){
        this.typeofbiopsyRepository = typeofbiopsyRepository;
    }

    public List<Typeofbiopsy> getTypeofbiopsys(){
        return typeofbiopsyRepository.findAll();
    }
    @SneakyThrows
    public Typeofbiopsy getTypeofbiopsy(Integer id){
        return typeofbiopsyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofbiopsy identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofbiopsy(Typeofbiopsy entity){

        if (entity.getId() != null && typeofbiopsyRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofbiopsy identified by ID:{" + entity.getId() + "} already exists.");

        typeofbiopsyRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofbiopsy(Integer id){

        typeofbiopsyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofbiopsy identified by id:{"+id+"} was not found."));
        typeofbiopsyRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofbiopsy(Typeofbiopsy entity) {

        Typeofbiopsy setEntity = typeofbiopsyRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofbiopsy identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        typeofbiopsyRepository.save(setEntity);

    }
}