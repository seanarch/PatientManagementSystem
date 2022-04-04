package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofmanagement;
import com.PatManSystem.main.Repository.TypeofmanagementRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofmanagementService {


    private final TypeofmanagementRepository typeofmanagementRepository;

    @Autowired
    public TypeofmanagementService(TypeofmanagementRepository typeofmanagementRepository){
        this.typeofmanagementRepository = typeofmanagementRepository;
    }

    public List<Typeofmanagement> getTypeofmanagements(){
        return typeofmanagementRepository.findAll();
    }
    @SneakyThrows
    public Typeofmanagement getTypeofmanagement(Integer id){
        return typeofmanagementRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofmanagement identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofmanagement(Typeofmanagement entity){

        if(typeofmanagementRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofmanagement identified by ID:{"+entity.getId()+"} already exists.");

        typeofmanagementRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofmanagement(Integer id){

        typeofmanagementRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofmanagement identified by id:{"+id+"} was not found."));
        typeofmanagementRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofmanagement(Typeofmanagement entity){

        Typeofmanagement setEntity = typeofmanagementRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofmanagement identified by id:{"+entity.getId()+"} was not found."));

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

        typeofmanagementRepository.save(setEntity);

    }
}
