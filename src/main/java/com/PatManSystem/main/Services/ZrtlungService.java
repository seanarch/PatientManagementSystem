package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtlung;
import com.PatManSystem.main.Repository.ZrtlungRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZrtlungService {


    private final ZrtlungRepository zrtlungRepository;

    @Autowired
    public ZrtlungService(ZrtlungRepository zrtlungRepository){
        this.zrtlungRepository = zrtlungRepository;
    }

    public List<Zrtlung> getZrtlungs(){
        return zrtlungRepository.findAll();
    }
    @SneakyThrows
    public Zrtlung getZrtlung(Integer id){
        return zrtlungRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtlung identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtlung(Zrtlung entity){

        if(zrtlungRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtlung identified by ID:{"+entity.getId()+"} already exists.");

        zrtlungRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtlung(Integer id){

        zrtlungRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtlung identified by id:{"+id+"} was not found."));
        zrtlungRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtlung(Zrtlung entity){

        Zrtlung setEntity = zrtlungRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtlung identified by id:{"+entity.getId()+"} was not found."));

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

        zrtlungRepository.save(setEntity);

    }
}
