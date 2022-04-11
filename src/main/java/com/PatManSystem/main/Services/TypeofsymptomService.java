package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofsymptom;
import com.PatManSystem.main.Repository.TypeofsymptomRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeofsymptomService {


    private final TypeofsymptomRepository typeofsymptomRepository;

    @Autowired
    public TypeofsymptomService(TypeofsymptomRepository typeofsymptomRepository){
        this.typeofsymptomRepository = typeofsymptomRepository;
    }

    public List<Typeofsymptom> getTypeofsymptoms(){
        return typeofsymptomRepository.findAll();
    }
    @SneakyThrows
    public Typeofsymptom getTypeofsymptom(Integer id){
        return typeofsymptomRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofsymptom identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofsymptom(Typeofsymptom entity){

        if (entity.getId() != null && typeofsymptomRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofsymptom identified by ID:{" + entity.getId() + "} already exists.");

        typeofsymptomRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofsymptom(Integer id){

        typeofsymptomRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofsymptom identified by id:{"+id+"} was not found."));
        typeofsymptomRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofsymptom(Typeofsymptom entity) {

        Typeofsymptom setEntity = typeofsymptomRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofsymptom identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        typeofsymptomRepository.save(setEntity);

    }
}
