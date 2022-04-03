package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Lung;
import com.PatManSystem.main.Repository.LungRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class LungService {


    private final LungRepository lungRepository;

    @Autowired
    public LungService(LungRepository lungRepository){
        this.lungRepository = lungRepository;
    }

    public List<Lung> getLungs(){
        return lungRepository.findAll();
    }
    @SneakyThrows
    public Lung getLung(Integer id){
        return lungRepository.findById(id).orElseThrow(() -> new NotFoundException("Lung identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newLung(Lung entity){

        if(lungRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Lung identified by ID:{"+entity.getId()+"} already exists.");

        lungRepository.save(entity);
    }

    @SneakyThrows
    public void deleteLung(Integer id){

        lungRepository.findById(id).orElseThrow(() -> new NotFoundException("Lung identified by id:{"+id+"} was not found."));
        lungRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateLung(Lung entity){

        Lung setEntity = lungRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Lung identified by id:{"+entity.getId()+"} was not found."));

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

        lungRepository.save(setEntity);

    }
}