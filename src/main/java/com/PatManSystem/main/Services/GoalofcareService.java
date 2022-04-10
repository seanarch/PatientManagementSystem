package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Goalofcare;
import com.PatManSystem.main.Repository.GoalofcareRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        if(entity.getId() != null && goalofcareRepository.findById(entity.getId()).isPresent())
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

        if(entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        goalofcareRepository.save(setEntity);

    }
}
