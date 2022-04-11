package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Supine;
import com.PatManSystem.main.Repository.SupineRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupineService {


    private final SupineRepository supineRepository;

    @Autowired
    public SupineService(SupineRepository supineRepository){
        this.supineRepository = supineRepository;
    }

    public List<Supine> getSupines(){
        return supineRepository.findAll();
    }
    @SneakyThrows
    public Supine getSupine(Integer id){
        return supineRepository.findById(id).orElseThrow(() -> new NotFoundException("Supine identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newSupine(Supine entity){

        if (entity.getId() != null && supineRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Supine identified by ID:{" + entity.getId() + "} already exists.");

        supineRepository.save(entity);
    }

    @SneakyThrows
    public void deleteSupine(Integer id){

        supineRepository.findById(id).orElseThrow(() -> new NotFoundException("Supine identified by id:{"+id+"} was not found."));
        supineRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateSupine(Supine entity) {

        Supine setEntity = supineRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Supine identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        supineRepository.save(setEntity);

    }
}
