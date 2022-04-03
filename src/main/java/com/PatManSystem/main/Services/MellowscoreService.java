package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Mellowscore;
import com.PatManSystem.main.Repository.MellowscoreRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class MellowscoreService {


    private final MellowscoreRepository mellowscoreRepository;

    @Autowired
    public MellowscoreService(MellowscoreRepository mellowscoreRepository){
        this.mellowscoreRepository = mellowscoreRepository;
    }

    public List<Mellowscore> getMellowscores(){
        return mellowscoreRepository.findAll();
    }
    @SneakyThrows
    public Mellowscore getMellowscore(Integer id){
        return mellowscoreRepository.findById(id).orElseThrow(() -> new NotFoundException("Mellowscore identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newMellowscore(Mellowscore entity){

        if(mellowscoreRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Mellowscore identified by ID:{"+entity.getId()+"} already exists.");

        mellowscoreRepository.save(entity);
    }

    @SneakyThrows
    public void deleteMellowscore(Integer id){

        mellowscoreRepository.findById(id).orElseThrow(() -> new NotFoundException("Mellowscore identified by id:{"+id+"} was not found."));
        mellowscoreRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateMellowscore(Mellowscore entity){

        Mellowscore setEntity = mellowscoreRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Mellowscore identified by id:{"+entity.getId()+"} was not found."));

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

        mellowscoreRepository.save(setEntity);

    }
}