package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrthep;
import com.PatManSystem.main.Repository.ZrthepRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZrthepService {


    private final ZrthepRepository zrthepRepository;

    @Autowired
    public ZrthepService(ZrthepRepository zrthepRepository){
        this.zrthepRepository = zrthepRepository;
    }

    public List<Zrthep> getZrtheps(){
        return zrthepRepository.findAll();
    }
    @SneakyThrows
    public Zrthep getZrthep(Integer id){
        return zrthepRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrthep identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrthep(Zrthep entity){

        if (entity.getId() != null && zrthepRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrthep identified by ID:{" + entity.getId() + "} already exists.");

        zrthepRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrthep(Integer id){

        zrthepRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrthep identified by id:{"+id+"} was not found."));
        zrthepRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrthep(Zrthep entity) {

        Zrthep setEntity = zrthepRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrthep identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        zrthepRepository.save(setEntity);

    }
}
