package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Skin;
import com.PatManSystem.main.Repository.SkinRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinService {


    private final SkinRepository skinRepository;

    @Autowired
    public SkinService(SkinRepository skinRepository){
        this.skinRepository = skinRepository;
    }

    public List<Skin> getSkins(){
        return skinRepository.findAll();
    }
    @SneakyThrows
    public Skin getSkin(Integer id){
        return skinRepository.findById(id).orElseThrow(() -> new NotFoundException("Skin identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newSkin(Skin entity){

        if (entity.getId() != null && skinRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Skin identified by ID:{" + entity.getId() + "} already exists.");

        skinRepository.save(entity);
    }

    @SneakyThrows
    public void deleteSkin(Integer id){

        skinRepository.findById(id).orElseThrow(() -> new NotFoundException("Skin identified by id:{"+id+"} was not found."));
        skinRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateSkin(Skin entity) {

        Skin setEntity = skinRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Skin identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        skinRepository.save(setEntity);

    }
}
