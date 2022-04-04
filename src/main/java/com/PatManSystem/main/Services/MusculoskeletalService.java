package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Musculoskeletal;
import com.PatManSystem.main.Repository.MusculoskeletalRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class MusculoskeletalService {


    private final MusculoskeletalRepository musculoskeletalRepository;

    @Autowired
    public MusculoskeletalService(MusculoskeletalRepository musculoskeletalRepository){
        this.musculoskeletalRepository = musculoskeletalRepository;
    }

    public List<Musculoskeletal> getMusculoskeletals(){
        return musculoskeletalRepository.findAll();
    }
    @SneakyThrows
    public Musculoskeletal getMusculoskeletal(Integer id){
        return musculoskeletalRepository.findById(id).orElseThrow(() -> new NotFoundException("Musculoskeletal identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newMusculoskeletal(Musculoskeletal entity){

        if(musculoskeletalRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Musculoskeletal identified by ID:{"+entity.getId()+"} already exists.");

        musculoskeletalRepository.save(entity);
    }

    @SneakyThrows
    public void deleteMusculoskeletal(Integer id){

        musculoskeletalRepository.findById(id).orElseThrow(() -> new NotFoundException("Musculoskeletal identified by id:{"+id+"} was not found."));
        musculoskeletalRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateMusculoskeletal(Musculoskeletal entity){

        Musculoskeletal setEntity = musculoskeletalRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Musculoskeletal identified by id:{"+entity.getId()+"} was not found."));

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

        musculoskeletalRepository.save(setEntity);

    }
}
