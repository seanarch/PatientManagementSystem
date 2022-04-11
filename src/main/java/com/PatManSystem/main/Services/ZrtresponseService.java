package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtresponse;
import com.PatManSystem.main.Repository.ZrtresponseRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZrtresponseService {


    private final ZrtresponseRepository zrtresponseRepository;

    @Autowired
    public ZrtresponseService(ZrtresponseRepository zrtresponseRepository){
        this.zrtresponseRepository = zrtresponseRepository;
    }

    public List<Zrtresponse> getZrtresponses(){
        return zrtresponseRepository.findAll();
    }
    @SneakyThrows
    public Zrtresponse getZrtresponse(Integer id){
        return zrtresponseRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtresponse identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtresponse(Zrtresponse entity){

        if (entity.getId() != null && zrtresponseRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtresponse identified by ID:{" + entity.getId() + "} already exists.");

        zrtresponseRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtresponse(Integer id){

        zrtresponseRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtresponse identified by id:{"+id+"} was not found."));
        zrtresponseRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtresponse(Zrtresponse entity) {

        Zrtresponse setEntity = zrtresponseRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtresponse identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        zrtresponseRepository.save(setEntity);

    }
}
