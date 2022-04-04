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

        if(cardiacRepository.findById(entity.getId()).isPresent())
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

        cardiacRepository.save(setEntity);

    }
}
