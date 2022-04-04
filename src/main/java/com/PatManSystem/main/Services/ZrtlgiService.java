package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtlgi;
import com.PatManSystem.main.Repository.ZrtlgiRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZrtlgiService {


    private final ZrtlgiRepository zrtlgiRepository;

    @Autowired
    public ZrtlgiService(ZrtlgiRepository zrtlgiRepository){
        this.zrtlgiRepository = zrtlgiRepository;
    }

    public List<Zrtlgi> getZrtlgis(){
        return zrtlgiRepository.findAll();
    }
    @SneakyThrows
    public Zrtlgi getZrtlgi(Integer id){
        return zrtlgiRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtlgi identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtlgi(Zrtlgi entity){

        if(zrtlgiRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtlgi identified by ID:{"+entity.getId()+"} already exists.");

        zrtlgiRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtlgi(Integer id){

        zrtlgiRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtlgi identified by id:{"+id+"} was not found."));
        zrtlgiRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtlgi(Zrtlgi entity){

        Zrtlgi setEntity = zrtlgiRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtlgi identified by id:{"+entity.getId()+"} was not found."));

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

        zrtlgiRepository.save(setEntity);

    }
}
