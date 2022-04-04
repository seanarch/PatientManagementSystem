package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofpathology;
import com.PatManSystem.main.Repository.TypeofpathologyRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofpathologyService {


    private final TypeofpathologyRepository typeofpathologyRepository;

    @Autowired
    public TypeofpathologyService(TypeofpathologyRepository typeofpathologyRepository){
        this.typeofpathologyRepository = typeofpathologyRepository;
    }

    public List<Typeofpathology> getTypeofpathologys(){
        return typeofpathologyRepository.findAll();
    }
    @SneakyThrows
    public Typeofpathology getTypeofpathology(Integer id){
        return typeofpathologyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofpathology identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofpathology(Typeofpathology entity){

        if(typeofpathologyRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofpathology identified by ID:{"+entity.getId()+"} already exists.");

        typeofpathologyRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofpathology(Integer id){

        typeofpathologyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofpathology identified by id:{"+id+"} was not found."));
        typeofpathologyRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofpathology(Typeofpathology entity){

        Typeofpathology setEntity = typeofpathologyRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofpathology identified by id:{"+entity.getId()+"} was not found."));

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

        typeofpathologyRepository.save(setEntity);

    }
}
