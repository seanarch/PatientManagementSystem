package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Oral;
import com.PatManSystem.main.Repository.OralRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OralService {


    private final OralRepository oralRepository;

    @Autowired
    public OralService(OralRepository oralRepository){
        this.oralRepository = oralRepository;
    }

    public List<Oral> getOrals(){
        return oralRepository.findAll();
    }
    @SneakyThrows
    public Oral getOral(Integer id){
        return oralRepository.findById(id).orElseThrow(() -> new NotFoundException("Oral identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newOral(Oral entity){

        if (entity.getId() != null && oralRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Oral identified by ID:{" + entity.getId() + "} already exists.");

        oralRepository.save(entity);
    }

    @SneakyThrows
    public void deleteOral(Integer id){

        oralRepository.findById(id).orElseThrow(() -> new NotFoundException("Oral identified by id:{"+id+"} was not found."));
        oralRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateOral(Oral entity) {

        Oral setEntity = oralRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Oral identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        oralRepository.save(setEntity);

    }
}