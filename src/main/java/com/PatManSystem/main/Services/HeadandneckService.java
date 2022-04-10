package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Headandneck;
import com.PatManSystem.main.Repository.HeadandneckRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HeadandneckService {


    private final HeadandneckRepository headandneckRepository;

    @Autowired
    public HeadandneckService(HeadandneckRepository headandneckRepository){
        this.headandneckRepository = headandneckRepository;
    }

    public List<Headandneck> getHeadandnecks(){
        return headandneckRepository.findAll();
    }
    @SneakyThrows
    public Headandneck getHeadandneck(Integer id){
        return headandneckRepository.findById(id).orElseThrow(() -> new NotFoundException("Headandneck identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newHeadandneck(Headandneck entity){

        if(entity.getId() != null && headandneckRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Headandneck identified by ID:{"+entity.getId()+"} already exists.");

        headandneckRepository.save(entity);
    }

    @SneakyThrows
    public void deleteHeadandneck(Integer id){

        headandneckRepository.findById(id).orElseThrow(() -> new NotFoundException("Headandneck identified by id:{"+id+"} was not found."));
        headandneckRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateHeadandneck(Headandneck entity){

        Headandneck setEntity = headandneckRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Headandneck identified by id:{"+entity.getId()+"} was not found."));

        if(entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        headandneckRepository.save(setEntity);

    }
}