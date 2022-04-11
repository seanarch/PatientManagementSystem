package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofhistoryofpresentillness;
import com.PatManSystem.main.Repository.TypeofhistoryofpresentillnessRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeofhistoryofpresentillnessService {


    private final TypeofhistoryofpresentillnessRepository typeofhistoryofpresentillnessRepository;

    @Autowired
    public TypeofhistoryofpresentillnessService(TypeofhistoryofpresentillnessRepository typeofhistoryofpresentillnessRepository){
        this.typeofhistoryofpresentillnessRepository = typeofhistoryofpresentillnessRepository;
    }

    public List<Typeofhistoryofpresentillness> getTypeofhistoryofpresentillnesss(){
        return typeofhistoryofpresentillnessRepository.findAll();
    }
    @SneakyThrows
    public Typeofhistoryofpresentillness getTypeofhistoryofpresentillness(Integer id){
        return typeofhistoryofpresentillnessRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofhistoryofpresentillness identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofhistoryofpresentillness(Typeofhistoryofpresentillness entity){

        if (entity.getId() != null && typeofhistoryofpresentillnessRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofhistoryofpresentillness identified by ID:{" + entity.getId() + "} already exists.");

        typeofhistoryofpresentillnessRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofhistoryofpresentillness(Integer id){

        typeofhistoryofpresentillnessRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofhistoryofpresentillness identified by id:{"+id+"} was not found."));
        typeofhistoryofpresentillnessRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofhistoryofpresentillness(Typeofhistoryofpresentillness entity){

        Typeofhistoryofpresentillness setEntity = typeofhistoryofpresentillnessRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofhistoryofpresentillness identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        typeofhistoryofpresentillnessRepository.save(setEntity);

    }
}
