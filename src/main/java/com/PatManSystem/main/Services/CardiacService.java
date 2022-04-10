package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Cardiac;
import com.PatManSystem.main.Repository.CardiacRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class CardiacService {


    private final CardiacRepository cardiacRepository;

    @Autowired
    public CardiacService(CardiacRepository cardiacRepository){
        this.cardiacRepository = cardiacRepository;
    }

    public List<Cardiac> getCardiacs(){
        return cardiacRepository.findAll();
    }
    @SneakyThrows
    public Cardiac getCardiac(Integer id){
        return cardiacRepository.findById(id).orElseThrow(() -> new NotFoundException("Cardiac identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newCardiac(Cardiac entity){

        if(entity.getId() != null && cardiacRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Cardiac identified by ID:{"+entity.getId()+"} already exists.");

        cardiacRepository.save(entity);
    }

    @SneakyThrows
    public void deleteCardiac(Integer id){

        cardiacRepository.findById(id).orElseThrow(() -> new NotFoundException("Cardiac identified by id:{"+id+"} was not found."));
        cardiacRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateCardiac(Cardiac entity){

        Cardiac setEntity = cardiacRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Cardiac identified by id:{"+entity.getId()+"} was not found."));

        if(entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        cardiacRepository.save(setEntity);

    }
}
