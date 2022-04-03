package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofbiopsy;
import com.PatManSystem.main.Repository.TypeofbiopsyRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofbiopsyService {


    private final TypeofbiopsyRepository typeofbiopsyRepository;

    @Autowired
    public TypeofbiopsyService(TypeofbiopsyRepository typeofbiopsyRepository){
        this.typeofbiopsyRepository = typeofbiopsyRepository;
    }

    public List<Typeofbiopsy> getTypeofbiopsys(){
        return typeofbiopsyRepository.findAll();
    }
    @SneakyThrows
    public Typeofbiopsy getTypeofbiopsy(Integer id){
        return typeofbiopsyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofbiopsy identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofbiopsy(Typeofbiopsy entity){

        if(typeofbiopsyRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofbiopsy identified by ID:{"+entity.getId()+"} already exists.");

        typeofbiopsyRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofbiopsy(Integer id){

        typeofbiopsyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofbiopsy identified by id:{"+id+"} was not found."));
        typeofbiopsyRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofbiopsy(Typeofbiopsy entity){

        Typeofbiopsy setEntity = typeofbiopsyRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofbiopsy identified by id:{"+entity.getId()+"} was not found."));

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

        typeofbiopsyRepository.save(setEntity);

    }
}