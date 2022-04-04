package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Supine;
import com.PatManSystem.main.Repository.SupineRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class SupineService {


    private final SupineRepository supineRepository;

    @Autowired
    public SupineService(SupineRepository supineRepository){
        this.supineRepository = supineRepository;
    }

    public List<Supine> getSupines(){
        return supineRepository.findAll();
    }
    @SneakyThrows
    public Supine getSupine(Integer id){
        return supineRepository.findById(id).orElseThrow(() -> new NotFoundException("Supine identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newSupine(Supine entity){

        if(supineRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Supine identified by ID:{"+entity.getId()+"} already exists.");

        supineRepository.save(entity);
    }

    @SneakyThrows
    public void deleteSupine(Integer id){

        supineRepository.findById(id).orElseThrow(() -> new NotFoundException("Supine identified by id:{"+id+"} was not found."));
        supineRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateSupine(Supine entity){

        Supine setEntity = supineRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Supine identified by id:{"+entity.getId()+"} was not found."));

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

        supineRepository.save(setEntity);

    }
}
