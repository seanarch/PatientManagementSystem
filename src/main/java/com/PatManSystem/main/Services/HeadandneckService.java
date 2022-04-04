package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Headandneck;
import com.PatManSystem.main.Repository.HeadandneckRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class HeadandneckService {


    private final HeadandneckRepository headandneckRepository;

    @Autowired
    public HeadandneckService(HeadandneckRepository headandneckRepository){
        this.headandneckRepository = headandneckRepository;
    }

    public List<Headandneck> getHeadandnecks(){
        return headandneckRepository.findAll();
    }
    @SneakyThrows
    public Headandneck getHeadandneck(Integer id){
        return headandneckRepository.findById(id).orElseThrow(() -> new NotFoundException("Headandneck identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newHeadandneck(Headandneck entity){

        if(headandneckRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Headandneck identified by ID:{"+entity.getId()+"} already exists.");

        headandneckRepository.save(entity);
    }

    @SneakyThrows
    public void deleteHeadandneck(Integer id){

        headandneckRepository.findById(id).orElseThrow(() -> new NotFoundException("Headandneck identified by id:{"+id+"} was not found."));
        headandneckRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateHeadandneck(Headandneck entity){

        Headandneck setEntity = headandneckRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Headandneck identified by id:{"+entity.getId()+"} was not found."));

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

        headandneckRepository.save(setEntity);

    }
}