package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofsymptom;
import com.PatManSystem.main.Repository.TypeofsymptomRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofsymptomService {


    private final TypeofsymptomRepository typeofsymptomRepository;

    @Autowired
    public TypeofsymptomService(TypeofsymptomRepository typeofsymptomRepository){
        this.typeofsymptomRepository = typeofsymptomRepository;
    }

    public List<Typeofsymptom> getTypeofsymptoms(){
        return typeofsymptomRepository.findAll();
    }
    @SneakyThrows
    public Typeofsymptom getTypeofsymptom(Integer id){
        return typeofsymptomRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofsymptom identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofsymptom(Typeofsymptom entity){

        if(typeofsymptomRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofsymptom identified by ID:{"+entity.getId()+"} already exists.");

        typeofsymptomRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofsymptom(Integer id){

        typeofsymptomRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofsymptom identified by id:{"+id+"} was not found."));
        typeofsymptomRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofsymptom(Typeofsymptom entity){

        Typeofsymptom setEntity = typeofsymptomRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofsymptom identified by id:{"+entity.getId()+"} was not found."));

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

        typeofsymptomRepository.save(setEntity);

    }
}
