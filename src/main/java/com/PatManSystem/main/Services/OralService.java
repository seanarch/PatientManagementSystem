package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Oral;
import com.PatManSystem.main.Repository.OralRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class OralService {


    private final OralRepository oralRepository;

    @Autowired
    public OralService(OralRepository oralRepository){
        this.oralRepository = oralRepository;
    }

    public List<Oral> getOrals(){
        return oralRepository.findAll();
    }
    @SneakyThrows
    public Oral getOral(Integer id){
        return oralRepository.findById(id).orElseThrow(() -> new NotFoundException("Oral identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newOral(Oral entity){

        if(oralRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Oral identified by ID:{"+entity.getId()+"} already exists.");

        oralRepository.save(entity);
    }

    @SneakyThrows
    public void deleteOral(Integer id){

        oralRepository.findById(id).orElseThrow(() -> new NotFoundException("Oral identified by id:{"+id+"} was not found."));
        oralRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateOral(Oral entity){

        Oral setEntity = oralRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Oral identified by id:{"+entity.getId()+"} was not found."));

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

        oralRepository.save(setEntity);

    }
}