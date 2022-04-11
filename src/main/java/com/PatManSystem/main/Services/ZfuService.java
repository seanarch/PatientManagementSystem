package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zfu;
import com.PatManSystem.main.Repository.ZfuRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZfuService {


    private final ZfuRepository zfuRepository;

    @Autowired
    public ZfuService(ZfuRepository zfuRepository){
        this.zfuRepository = zfuRepository;
    }

    public List<Zfu> getZfus(){
        return zfuRepository.findAll();
    }
    @SneakyThrows
    public Zfu getZfu(Integer id){
        return zfuRepository.findById(id).orElseThrow(() -> new NotFoundException("Zfu identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZfu(Zfu entity){

        if (entity.getId() != null && zfuRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zfu identified by ID:{" + entity.getId() + "} already exists.");

        zfuRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZfu(Integer id){

        zfuRepository.findById(id).orElseThrow(() -> new NotFoundException("Zfu identified by id:{"+id+"} was not found."));
        zfuRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZfu(Zfu entity) {

        Zfu setEntity = zfuRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zfu identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        zfuRepository.save(setEntity);

    }
}
