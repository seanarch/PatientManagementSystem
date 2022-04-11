package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtgu;
import com.PatManSystem.main.Repository.ZrtguRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZrtguService {


    private final ZrtguRepository zrtguRepository;

    @Autowired
    public ZrtguService(ZrtguRepository zrtguRepository){
        this.zrtguRepository = zrtguRepository;
    }

    public List<Zrtgu> getZrtgus(){
        return zrtguRepository.findAll();
    }
    @SneakyThrows
    public Zrtgu getZrtgu(Integer id){
        return zrtguRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtgu identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtgu(Zrtgu entity){

        if (entity.getId() != null && zrtguRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtgu identified by ID:{" + entity.getId() + "} already exists.");

        zrtguRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtgu(Integer id){

        zrtguRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtgu identified by id:{"+id+"} was not found."));
        zrtguRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtgu(Zrtgu entity) {

        Zrtgu setEntity = zrtguRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtgu identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        zrtguRepository.save(setEntity);

    }
}
