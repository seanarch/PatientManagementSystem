package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Breath;
import com.PatManSystem.main.Repository.BreathRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class BreathService {


    private final BreathRepository breathRepository;

    @Autowired
    public BreathService(BreathRepository breathRepository){
        this.breathRepository = breathRepository;
    }

    public List<Breath> getBreaths(){
        return breathRepository.findAll();
    }
    @SneakyThrows
    public Breath getBreath(Integer id){
        return breathRepository.findById(id).orElseThrow(() -> new NotFoundException("Breath identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newBreath(Breath entity){

        if(breathRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Breath identified by ID:{"+entity.getId()+"} already exists.");

        breathRepository.save(entity);
    }

    @SneakyThrows
    public void deleteBreath(Integer id){

        breathRepository.findById(id).orElseThrow(() -> new NotFoundException("Breath identified by id:{"+id+"} was not found."));
        breathRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateBreath(Breath entity){

        Breath setEntity = breathRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Breath identified by id:{"+entity.getId()+"} was not found."));

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

        breathRepository.save(setEntity);

    }
}
