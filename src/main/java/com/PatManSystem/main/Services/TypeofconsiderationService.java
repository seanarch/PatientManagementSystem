package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofconsideration;
import com.PatManSystem.main.Repository.TypeofconsiderationRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofconsiderationService {


    private final TypeofconsiderationRepository typeofconsiderationRepository;

    @Autowired
    public TypeofconsiderationService(TypeofconsiderationRepository typeofconsiderationRepository){
        this.typeofconsiderationRepository = typeofconsiderationRepository;
    }

    public List<Typeofconsideration> getTypeofconsiderations(){
        return typeofconsiderationRepository.findAll();
    }
    @SneakyThrows
    public Typeofconsideration getTypeofconsideration(Integer id){
        return typeofconsiderationRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofconsideration identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofconsideration(Typeofconsideration entity){

        if(typeofconsiderationRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofconsideration identified by ID:{"+entity.getId()+"} already exists.");

        typeofconsiderationRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofconsideration(Integer id){

        typeofconsiderationRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofconsideration identified by id:{"+id+"} was not found."));
        typeofconsiderationRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofconsideration(Typeofconsideration entity){

        Typeofconsideration setEntity = typeofconsiderationRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofconsideration identified by id:{"+entity.getId()+"} was not found."));

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

        typeofconsiderationRepository.save(setEntity);

    }
}