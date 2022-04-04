package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Skin;
import com.PatManSystem.main.Repository.SkinRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class SkinService {


    private final SkinRepository skinRepository;

    @Autowired
    public SkinService(SkinRepository skinRepository){
        this.skinRepository = skinRepository;
    }

    public List<Skin> getSkins(){
        return skinRepository.findAll();
    }
    @SneakyThrows
    public Skin getSkin(Integer id){
        return skinRepository.findById(id).orElseThrow(() -> new NotFoundException("Skin identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newSkin(Skin entity){

        if(skinRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Skin identified by ID:{"+entity.getId()+"} already exists.");

        skinRepository.save(entity);
    }

    @SneakyThrows
    public void deleteSkin(Integer id){

        skinRepository.findById(id).orElseThrow(() -> new NotFoundException("Skin identified by id:{"+id+"} was not found."));
        skinRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateSkin(Skin entity){

        Skin setEntity = skinRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Skin identified by id:{"+entity.getId()+"} was not found."));

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

        skinRepository.save(setEntity);

    }
}
