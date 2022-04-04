package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtgu;
import com.PatManSystem.main.Repository.ZrtguRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZrtguService {


    private final ZrtguRepository zrtguRepository;

    @Autowired
    public ZrtguService(ZrtguRepository zrtguRepository){
        this.zrtguRepository = zrtguRepository;
    }

    public List<Zrtgu> getZrtgus(){
        return zrtguRepository.findAll();
    }
    @SneakyThrows
    public Zrtgu getZrtgu(Integer id){
        return zrtguRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtgu identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtgu(Zrtgu entity){

        if(zrtguRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtgu identified by ID:{"+entity.getId()+"} already exists.");

        zrtguRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtgu(Integer id){

        zrtguRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtgu identified by id:{"+id+"} was not found."));
        zrtguRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtgu(Zrtgu entity){

        Zrtgu setEntity = zrtguRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtgu identified by id:{"+entity.getId()+"} was not found."));

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

        zrtguRepository.save(setEntity);

    }
}
