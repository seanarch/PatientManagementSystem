package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zfu;
import com.PatManSystem.main.Repository.ZfuRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZfuService {


    private final ZfuRepository zfuRepository;

    @Autowired
    public ZfuService(ZfuRepository zfuRepository){
        this.zfuRepository = zfuRepository;
    }

    public List<Zfu> getZfus(){
        return zfuRepository.findAll();
    }
    @SneakyThrows
    public Zfu getZfu(Integer id){
        return zfuRepository.findById(id).orElseThrow(() -> new NotFoundException("Zfu identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZfu(Zfu entity){

        if(zfuRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zfu identified by ID:{"+entity.getId()+"} already exists.");

        zfuRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZfu(Integer id){

        zfuRepository.findById(id).orElseThrow(() -> new NotFoundException("Zfu identified by id:{"+id+"} was not found."));
        zfuRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZfu(Zfu entity){

        Zfu setEntity = zfuRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zfu identified by id:{"+entity.getId()+"} was not found."));

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

        zfuRepository.save(setEntity);

    }
}
