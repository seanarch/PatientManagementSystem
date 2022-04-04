package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Mrcdyspnoeascale;
import com.PatManSystem.main.Repository.MrcdyspnoeascaleRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class MrcdyspnoeascaleService {


    private final MrcdyspnoeascaleRepository mrcdyspnoeascaleRepository;

    @Autowired
    public MrcdyspnoeascaleService(MrcdyspnoeascaleRepository mrcdyspnoeascaleRepository){
        this.mrcdyspnoeascaleRepository = mrcdyspnoeascaleRepository;
    }

    public List<Mrcdyspnoeascale> getMrcdyspnoeascales(){
        return mrcdyspnoeascaleRepository.findAll();
    }
    @SneakyThrows
    public Mrcdyspnoeascale getMrcdyspnoeascale(Integer id){
        return mrcdyspnoeascaleRepository.findById(id).orElseThrow(() -> new NotFoundException("Mrcdyspnoeascale identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newMrcdyspnoeascale(Mrcdyspnoeascale entity){

        if(mrcdyspnoeascaleRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Mrcdyspnoeascale identified by ID:{"+entity.getId()+"} already exists.");

        mrcdyspnoeascaleRepository.save(entity);
    }

    @SneakyThrows
    public void deleteMrcdyspnoeascale(Integer id){

        mrcdyspnoeascaleRepository.findById(id).orElseThrow(() -> new NotFoundException("Mrcdyspnoeascale identified by id:{"+id+"} was not found."));
        mrcdyspnoeascaleRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateMrcdyspnoeascale(Mrcdyspnoeascale entity){

        Mrcdyspnoeascale setEntity = mrcdyspnoeascaleRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Mrcdyspnoeascale identified by id:{"+entity.getId()+"} was not found."));

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

        mrcdyspnoeascaleRepository.save(setEntity);

    }
}