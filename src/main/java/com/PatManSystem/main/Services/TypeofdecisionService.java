package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofdecision;
import com.PatManSystem.main.Repository.TypeofdecisionRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofdecisionService {


    private final TypeofdecisionRepository typeofdecisionRepository;

    @Autowired
    public TypeofdecisionService(TypeofdecisionRepository typeofdecisionRepository){
        this.typeofdecisionRepository = typeofdecisionRepository;
    }

    public List<Typeofdecision> getTypeofdecisions(){
        return typeofdecisionRepository.findAll();
    }
    @SneakyThrows
    public Typeofdecision getTypeofdecision(Integer id){
        return typeofdecisionRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofdecision identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofdecision(Typeofdecision entity){

        if(typeofdecisionRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofdecision identified by ID:{"+entity.getId()+"} already exists.");

        typeofdecisionRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofdecision(Integer id){

        typeofdecisionRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofdecision identified by id:{"+id+"} was not found."));
        typeofdecisionRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofdecision(Typeofdecision entity){

        Typeofdecision setEntity = typeofdecisionRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofdecision identified by id:{"+entity.getId()+"} was not found."));

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

        typeofdecisionRepository.save(setEntity);

    }
}
