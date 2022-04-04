package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofradiationtherapy;
import com.PatManSystem.main.Repository.TypeofradiationtherapyRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofradiationtherapyService {


    private final TypeofradiationtherapyRepository typeofradiationtherapyRepository;

    @Autowired
    public TypeofradiationtherapyService(TypeofradiationtherapyRepository typeofradiationtherapyRepository){
        this.typeofradiationtherapyRepository = typeofradiationtherapyRepository;
    }

    public List<Typeofradiationtherapy> getTypeofradiationtherapys(){
        return typeofradiationtherapyRepository.findAll();
    }
    @SneakyThrows
    public Typeofradiationtherapy getTypeofradiationtherapy(Integer id){
        return typeofradiationtherapyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofradiationtherapy identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofradiationtherapy(Typeofradiationtherapy entity){

        if(typeofradiationtherapyRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofradiationtherapy identified by ID:{"+entity.getId()+"} already exists.");

        typeofradiationtherapyRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofradiationtherapy(Integer id){

        typeofradiationtherapyRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofradiationtherapy identified by id:{"+id+"} was not found."));
        typeofradiationtherapyRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofradiationtherapy(Typeofradiationtherapy entity){

        Typeofradiationtherapy setEntity = typeofradiationtherapyRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofradiationtherapy identified by id:{"+entity.getId()+"} was not found."));

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

        typeofradiationtherapyRepository.save(setEntity);

    }
}
