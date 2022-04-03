package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofrecure;
import com.PatManSystem.main.Repository.TypeofrecureRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofrecureService {


    private final TypeofrecureRepository typeofrecureRepository;

    @Autowired
    public TypeofrecureService(TypeofrecureRepository typeofrecureRepository){
        this.typeofrecureRepository = typeofrecureRepository;
    }

    public List<Typeofrecure> getTypeofrecures(){
        return typeofrecureRepository.findAll();
    }
    @SneakyThrows
    public Typeofrecure getTypeofrecure(Integer id){
        return typeofrecureRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofrecure identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofrecure(Typeofrecure entity){

        if(typeofrecureRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofrecure identified by ID:{"+entity.getId()+"} already exists.");

        typeofrecureRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofrecure(Integer id){

        typeofrecureRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofrecure identified by id:{"+id+"} was not found."));
        typeofrecureRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofrecure(Typeofrecure entity){

        Typeofrecure setEntity = typeofrecureRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofrecure identified by id:{"+entity.getId()+"} was not found."));

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

        typeofrecureRepository.save(setEntity);

    }
}
