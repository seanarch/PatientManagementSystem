package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofdiagnosticimaging;
import com.PatManSystem.main.Repository.TypeofdiagnosticimagingRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class TypeofdiagnosticimagingService {


    private final TypeofdiagnosticimagingRepository typeofdiagnosticimagingRepository;

    @Autowired
    public TypeofdiagnosticimagingService(TypeofdiagnosticimagingRepository typeofdiagnosticimagingRepository){
        this.typeofdiagnosticimagingRepository = typeofdiagnosticimagingRepository;
    }

    public List<Typeofdiagnosticimaging> getTypeofdiagnosticimagings(){
        return typeofdiagnosticimagingRepository.findAll();
    }
    @SneakyThrows
    public Typeofdiagnosticimaging getTypeofdiagnosticimaging(Integer id){
        return typeofdiagnosticimagingRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofdiagnosticimaging identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofdiagnosticimaging(Typeofdiagnosticimaging entity){

        if(typeofdiagnosticimagingRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofdiagnosticimaging identified by ID:{"+entity.getId()+"} already exists.");

        typeofdiagnosticimagingRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofdiagnosticimaging(Integer id){

        typeofdiagnosticimagingRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofdiagnosticimaging identified by id:{"+id+"} was not found."));
        typeofdiagnosticimagingRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofdiagnosticimaging(Typeofdiagnosticimaging entity){

        Typeofdiagnosticimaging setEntity = typeofdiagnosticimagingRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofdiagnosticimaging identified by id:{"+entity.getId()+"} was not found."));

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

        typeofdiagnosticimagingRepository.save(setEntity);

    }
}
