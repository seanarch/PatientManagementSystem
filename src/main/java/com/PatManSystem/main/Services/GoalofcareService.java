package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Goalofcare;
import com.PatManSystem.main.Repository.GoalofcareRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class GoalofcareService {


    private final GoalofcareRepository goalofcareRepository;

    @Autowired
    public GoalofcareService(GoalofcareRepository goalofcareRepository){
        this.goalofcareRepository = goalofcareRepository;
    }

    public List<Goalofcare> getGoalofcares(){
        return goalofcareRepository.findAll();
    }
    @SneakyThrows
    public Goalofcare getGoalofcare(Integer id){
        return goalofcareRepository.findById(id).orElseThrow(() -> new NotFoundException("Goalofcare identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newGoalofcare(Goalofcare entity){

        if(goalofcareRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Goalofcare identified by ID:{"+entity.getId()+"} already exists.");

        goalofcareRepository.save(entity);
    }

    @SneakyThrows
    public void deleteGoalofcare(Integer id){

        goalofcareRepository.findById(id).orElseThrow(() -> new NotFoundException("Goalofcare identified by id:{"+id+"} was not found."));
        goalofcareRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateGoalofcare(Goalofcare entity){

        Goalofcare setEntity = goalofcareRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Goalofcare identified by id:{"+entity.getId()+"} was not found."));

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

        goalofcareRepository.save(setEntity);

    }
}
