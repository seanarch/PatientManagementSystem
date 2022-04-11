package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtskin;
import com.PatManSystem.main.Repository.ZrtskinRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZrtskinService {


    private final ZrtskinRepository zrtskinRepository;

    @Autowired
    public ZrtskinService(ZrtskinRepository zrtskinRepository){
        this.zrtskinRepository = zrtskinRepository;
    }

    public List<Zrtskin> getZrtskins(){
        return zrtskinRepository.findAll();
    }
    @SneakyThrows
    public Zrtskin getZrtskin(Integer id){
        return zrtskinRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtskin identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtskin(Zrtskin entity){

        if (entity.getId() != null && zrtskinRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtskin identified by ID:{" + entity.getId() + "} already exists.");

        zrtskinRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtskin(Integer id){

        zrtskinRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtskin identified by id:{"+id+"} was not found."));
        zrtskinRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtskin(Zrtskin entity) {

        Zrtskin setEntity = zrtskinRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtskin identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        zrtskinRepository.save(setEntity);

    }
}
