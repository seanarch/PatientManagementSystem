package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtplan;
import com.PatManSystem.main.Repository.ZrtplanRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZrtplanService {


    private final ZrtplanRepository zrtplanRepository;

    @Autowired
    public ZrtplanService(ZrtplanRepository zrtplanRepository){
        this.zrtplanRepository = zrtplanRepository;
    }

    public List<Zrtplan> getZrtplans(){
        return zrtplanRepository.findAll();
    }
    @SneakyThrows
    public Zrtplan getZrtplan(Integer id){
        return zrtplanRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtplan identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtplan(Zrtplan entity){

        if (entity.getId() != null && zrtplanRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtplan identified by ID:{" + entity.getId() + "} already exists.");

        zrtplanRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtplan(Integer id){

        zrtplanRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtplan identified by id:{"+id+"} was not found."));
        zrtplanRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtplan(Zrtplan entity) {

        Zrtplan setEntity = zrtplanRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtplan identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        zrtplanRepository.save(setEntity);

    }
}