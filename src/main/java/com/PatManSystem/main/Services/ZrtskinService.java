package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Zrtskin;
import com.PatManSystem.main.Repository.ZrtskinRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ZrtskinService {


    private final ZrtskinRepository zrtskinRepository;

    @Autowired
    public ZrtskinService(ZrtskinRepository zrtskinRepository){
        this.zrtskinRepository = zrtskinRepository;
    }

    public List<Zrtskin> getZrtskins(){
        return zrtskinRepository.findAll();
    }
    @SneakyThrows
    public Zrtskin getZrtskin(Integer id){
        return zrtskinRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtskin identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newZrtskin(Zrtskin entity){

        if(zrtskinRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Zrtskin identified by ID:{"+entity.getId()+"} already exists.");

        zrtskinRepository.save(entity);
    }

    @SneakyThrows
    public void deleteZrtskin(Integer id){

        zrtskinRepository.findById(id).orElseThrow(() -> new NotFoundException("Zrtskin identified by id:{"+id+"} was not found."));
        zrtskinRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateZrtskin(Zrtskin entity){

        Zrtskin setEntity = zrtskinRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Zrtskin identified by id:{"+entity.getId()+"} was not found."));

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

        zrtskinRepository.save(setEntity);

    }
}
