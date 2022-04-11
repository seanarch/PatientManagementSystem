package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofdecision;
import com.PatManSystem.main.Repository.TypeofdecisionRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeofdecisionService {


    private final TypeofdecisionRepository typeofdecisionRepository;

    @Autowired
    public TypeofdecisionService(TypeofdecisionRepository typeofdecisionRepository){
        this.typeofdecisionRepository = typeofdecisionRepository;
    }

    public List<Typeofdecision> getTypeofdecisions(){
        return typeofdecisionRepository.findAll();
    }
    @SneakyThrows
    public Typeofdecision getTypeofdecision(Integer id){
        return typeofdecisionRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofdecision identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofdecision(Typeofdecision entity){

        if (entity.getId() != null && typeofdecisionRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofdecision identified by ID:{" + entity.getId() + "} already exists.");

        typeofdecisionRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofdecision(Integer id){

        typeofdecisionRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofdecision identified by id:{"+id+"} was not found."));
        typeofdecisionRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofdecision(Typeofdecision entity) {

        Typeofdecision setEntity = typeofdecisionRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofdecision identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        typeofdecisionRepository.save(setEntity);

    }
}
