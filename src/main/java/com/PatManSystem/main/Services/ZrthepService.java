package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrthep;
import com.PatManSystem.main.Repository.ZrthepRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZrthepService {


    private final ZrthepRepository zrthepRepository;

    @Autowired
    public ZrthepService(ZrthepRepository zrthepRepository){
        this.zrthepRepository = zrthepRepository;
    }

    public List<Zrthep> getZrtheps(){
        return zrthepRepository.findAll();
    }
    @SneakyThrows
    public Zrthep getZrthep(Integer id){
        return zrthepRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrthep identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrthep(Zrthep entity){

        if(zrthepRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrthep identified by ID:{"+entity.getId()+"} already exists.");

        zrthepRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrthep(Integer id){

        zrthepRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrthep identified by id:{"+id+"} was not found."));
        zrthepRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrthep(Zrthep entity){

        Zrthep setEntity = zrthepRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrthep identified by id:{"+entity.getId()+"} was not found."));

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

        zrthepRepository.save(setEntity);

    }
}
