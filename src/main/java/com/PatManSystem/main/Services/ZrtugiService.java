package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtugi;
import com.PatManSystem.main.Repository.ZrtugiRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZrtugiService {


    private final ZrtugiRepository zrtugiRepository;

    @Autowired
    public ZrtugiService(ZrtugiRepository zrtugiRepository){
        this.zrtugiRepository = zrtugiRepository;
    }

    public List<Zrtugi> getZrtugis(){
        return zrtugiRepository.findAll();
    }
    @SneakyThrows
    public Zrtugi getZrtugi(Integer id){
        return zrtugiRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtugi identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtugi(Zrtugi entity){

        if(zrtugiRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtugi identified by ID:{"+entity.getId()+"} already exists.");

        zrtugiRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtugi(Integer id){

        zrtugiRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtugi identified by id:{"+id+"} was not found."));
        zrtugiRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtugi(Zrtugi entity){

        Zrtugi setEntity = zrtugiRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtugi identified by id:{"+entity.getId()+"} was not found."));

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

        zrtugiRepository.save(setEntity);

    }
}
