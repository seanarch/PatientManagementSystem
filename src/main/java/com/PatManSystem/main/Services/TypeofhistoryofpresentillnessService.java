package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofhistoryofpresentillness;
import com.PatManSystem.main.Repository.TypeofhistoryofpresentillnessRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofhistoryofpresentillnessService {


    private final TypeofhistoryofpresentillnessRepository typeofhistoryofpresentillnessRepository;

    @Autowired
    public TypeofhistoryofpresentillnessService(TypeofhistoryofpresentillnessRepository typeofhistoryofpresentillnessRepository){
        this.typeofhistoryofpresentillnessRepository = typeofhistoryofpresentillnessRepository;
    }

    public List<Typeofhistoryofpresentillness> getTypeofhistoryofpresentillnesss(){
        return typeofhistoryofpresentillnessRepository.findAll();
    }
    @SneakyThrows
    public Typeofhistoryofpresentillness getTypeofhistoryofpresentillness(Integer id){
        return typeofhistoryofpresentillnessRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofhistoryofpresentillness identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofhistoryofpresentillness(Typeofhistoryofpresentillness entity){

        if(typeofhistoryofpresentillnessRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofhistoryofpresentillness identified by ID:{"+entity.getId()+"} already exists.");

        typeofhistoryofpresentillnessRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofhistoryofpresentillness(Integer id){

        typeofhistoryofpresentillnessRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofhistoryofpresentillness identified by id:{"+id+"} was not found."));
        typeofhistoryofpresentillnessRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofhistoryofpresentillness(Typeofhistoryofpresentillness entity){

        Typeofhistoryofpresentillness setEntity = typeofhistoryofpresentillnessRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofhistoryofpresentillness identified by id:{"+entity.getId()+"} was not found."));

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

        typeofhistoryofpresentillnessRepository.save(setEntity);

    }
}
