package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtplan;
import com.PatManSystem.main.Repository.ZrtplanRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZrtplanService {


    private final ZrtplanRepository zrtplanRepository;

    @Autowired
    public ZrtplanService(ZrtplanRepository zrtplanRepository){
        this.zrtplanRepository = zrtplanRepository;
    }

    public List<Zrtplan> getZrtplans(){
        return zrtplanRepository.findAll();
    }
    @SneakyThrows
    public Zrtplan getZrtplan(Integer id){
        return zrtplanRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtplan identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtplan(Zrtplan entity){

        if(zrtplanRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtplan identified by ID:{"+entity.getId()+"} already exists.");

        zrtplanRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtplan(Integer id){

        zrtplanRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtplan identified by id:{"+id+"} was not found."));
        zrtplanRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtplan(Zrtplan entity){

        Zrtplan setEntity = zrtplanRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtplan identified by id:{"+entity.getId()+"} was not found."));

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

        zrtplanRepository.save(setEntity);

    }
}