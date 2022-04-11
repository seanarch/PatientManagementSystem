package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtheme;
import com.PatManSystem.main.Repository.ZrthemeRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZrthemeService {


    private final ZrthemeRepository zrthemeRepository;

    @Autowired
    public ZrthemeService(ZrthemeRepository zrthemeRepository){
        this.zrthemeRepository = zrthemeRepository;
    }

    public List<Zrtheme> getZrthemes(){
        return zrthemeRepository.findAll();
    }
    @SneakyThrows
    public Zrtheme getZrtheme(Integer id){
        return zrthemeRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtheme identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtheme(Zrtheme entity){

        if (entity.getId() != null && zrthemeRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtheme identified by ID:{" + entity.getId() + "} already exists.");

        zrthemeRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtheme(Integer id){

        zrthemeRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtheme identified by id:{"+id+"} was not found."));
        zrthemeRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtheme(Zrtheme entity) {

        Zrtheme setEntity = zrthemeRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtheme identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        zrthemeRepository.save(setEntity);

    }
}
