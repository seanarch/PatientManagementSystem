package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofpathology;
import com.PatManSystem.main.Repository.TypeofpathologyRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeofpathologyService {


    private final TypeofpathologyRepository typeofpathologyRepository;

    @Autowired
    public TypeofpathologyService(TypeofpathologyRepository typeofpathologyRepository){
        this.typeofpathologyRepository = typeofpathologyRepository;
    }

    public List<Typeofpathology> getTypeofpathologys(){
        return typeofpathologyRepository.findAll();
    }
    @SneakyThrows
    public Typeofpathology getTypeofpathology(Integer id){
        return typeofpathologyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofpathology identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofpathology(Typeofpathology entity){

        if (entity.getId() != null && typeofpathologyRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofpathology identified by ID:{" + entity.getId() + "} already exists.");

        typeofpathologyRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofpathology(Integer id){

        typeofpathologyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofpathology identified by id:{"+id+"} was not found."));
        typeofpathologyRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofpathology(Typeofpathology entity) {

        Typeofpathology setEntity = typeofpathologyRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofpathology identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        typeofpathologyRepository.save(setEntity);

    }
}
