package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtresponse;
import com.PatManSystem.main.Repository.ZrtresponseRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZrtresponseService {


    private final ZrtresponseRepository zrtresponseRepository;

    @Autowired
    public ZrtresponseService(ZrtresponseRepository zrtresponseRepository){
        this.zrtresponseRepository = zrtresponseRepository;
    }

    public List<Zrtresponse> getZrtresponses(){
        return zrtresponseRepository.findAll();
    }
    @SneakyThrows
    public Zrtresponse getZrtresponse(Integer id){
        return zrtresponseRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtresponse identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtresponse(Zrtresponse entity){

        if(zrtresponseRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtresponse identified by ID:{"+entity.getId()+"} already exists.");

        zrtresponseRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtresponse(Integer id){

        zrtresponseRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtresponse identified by id:{"+id+"} was not found."));
        zrtresponseRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtresponse(Zrtresponse entity){

        Zrtresponse setEntity = zrtresponseRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtresponse identified by id:{"+entity.getId()+"} was not found."));

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

        zrtresponseRepository.save(setEntity);

    }
}
