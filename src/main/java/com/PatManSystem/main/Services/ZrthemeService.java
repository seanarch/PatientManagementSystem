package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtheme;
import com.PatManSystem.main.Repository.ZrthemeRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZrthemeService {


    private final ZrthemeRepository zrthemeRepository;

    @Autowired
    public ZrthemeService(ZrthemeRepository zrthemeRepository){
        this.zrthemeRepository = zrthemeRepository;
    }

    public List<Zrtheme> getZrthemes(){
        return zrthemeRepository.findAll();
    }
    @SneakyThrows
    public Zrtheme getZrtheme(Integer id){
        return zrthemeRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtheme identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtheme(Zrtheme entity){

        if(zrthemeRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtheme identified by ID:{"+entity.getId()+"} already exists.");

        zrthemeRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtheme(Integer id){

        zrthemeRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtheme identified by id:{"+id+"} was not found."));
        zrthemeRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtheme(Zrtheme entity){

        Zrtheme setEntity = zrthemeRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtheme identified by id:{"+entity.getId()+"} was not found."));

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

        zrthemeRepository.save(setEntity);

    }
}
