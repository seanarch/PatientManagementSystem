package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofrecure;
import com.PatManSystem.main.Repository.TypeofrecureRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeofrecureService {


    private final TypeofrecureRepository typeofrecureRepository;

    @Autowired
    public TypeofrecureService(TypeofrecureRepository typeofrecureRepository){
        this.typeofrecureRepository = typeofrecureRepository;
    }

    public List<Typeofrecure> getTypeofrecures(){
        return typeofrecureRepository.findAll();
    }
    @SneakyThrows
    public Typeofrecure getTypeofrecure(Integer id){
        return typeofrecureRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofrecure identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofrecure(Typeofrecure entity){

        if (entity.getId() != null && typeofrecureRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofrecure identified by ID:{" + entity.getId() + "} already exists.");

        typeofrecureRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofrecure(Integer id){

        typeofrecureRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofrecure identified by id:{"+id+"} was not found."));
        typeofrecureRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofrecure(Typeofrecure entity) {

        Typeofrecure setEntity = typeofrecureRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofrecure identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        typeofrecureRepository.save(setEntity);

    }
}
