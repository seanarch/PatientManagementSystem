package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Bodylocation;
import com.PatManSystem.main.Repository.BodylocationRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class BodylocationService {

    private final BodylocationRepository bodylocationRepository;

    @Autowired
    public BodylocationService(BodylocationRepository bodylocationRepository){
        this.bodylocationRepository = bodylocationRepository;
    }

    public List<Bodylocation> getBodylocations(){
        return bodylocationRepository.findAll();
    }
    @SneakyThrows
    public Bodylocation getBodylocation(Integer id){
        return bodylocationRepository.findById(id).orElseThrow(() -> new NotFoundException("Bodylocation identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newBodylocation(Bodylocation entity){

        if(entity.getId() != null && bodylocationRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Bodylocation identified by ID:{"+entity.getId()+"} already exists.");

        bodylocationRepository.save(entity);
    }

    @SneakyThrows
    public void deleteBodylocation(Integer id){

        bodylocationRepository.findById(id).orElseThrow(() -> new NotFoundException("Bodylocation identified by id:{"+id+"} was not found."));
        bodylocationRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateBodylocation(Bodylocation entity){

        Bodylocation setEntity = bodylocationRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Bodylocation identified by id:{"+entity.getId()+"} was not found."));

        if(entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        bodylocationRepository.save(setEntity);

    }
}
