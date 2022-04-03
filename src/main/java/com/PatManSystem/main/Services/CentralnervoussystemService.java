package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Centralnervoussystem;
import com.PatManSystem.main.Repository.CentralnervoussystemRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class CentralnervoussystemService {


    private final CentralnervoussystemRepository centralnervoussystemRepository;

    @Autowired
    public CentralnervoussystemService(CentralnervoussystemRepository centralnervoussystemRepository){
        this.centralnervoussystemRepository = centralnervoussystemRepository;
    }

    public List<Centralnervoussystem> getCentralnervoussystems(){
        return centralnervoussystemRepository.findAll();
    }
    @SneakyThrows
    public Centralnervoussystem getCentralnervoussystem(Integer id){
        return centralnervoussystemRepository.findById(id).orElseThrow(() -> new NotFoundException("Centralnervoussystem identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newCentralnervoussystem(Centralnervoussystem entity){

        if(centralnervoussystemRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Centralnervoussystem identified by ID:{"+entity.getId()+"} already exists.");

        centralnervoussystemRepository.save(entity);
    }

    @SneakyThrows
    public void deleteCentralnervoussystem(Integer id){

        centralnervoussystemRepository.findById(id).orElseThrow(() -> new NotFoundException("Centralnervoussystem identified by id:{"+id+"} was not found."));
        centralnervoussystemRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateCentralnervoussystem(Centralnervoussystem entity){

        Centralnervoussystem setEntity = centralnervoussystemRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Centralnervoussystem identified by id:{"+entity.getId()+"} was not found."));

        for (Method getter : entity.getClass().getMethods()) {
            Object get = "";
            if (getter.getName().startsWith("get") && getter.getParameterTypes().length == 0) {
                try {
                    get = getter.invoke(entity);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (get != null)
                    for (Method setter : setEntity.getClass().getMethods()) {
                        if (setter.getName().startsWith("set") && setter.getName().endsWith(getter.getName().substring(3)) && setter.getParameterTypes().length == 1) {
                            try {
                                setter.invoke(setEntity, get);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                            continue;
                        }
                    }
            }
        }

        centralnervoussystemRepository.save(setEntity);

    }
}