package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Musculoskeletal;
import com.PatManSystem.main.Repository.MusculoskeletalRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (entity.getId() != null && musculoskeletalRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Musculoskeletal identified by ID:{" + entity.getId() + "} already exists.");

        musculoskeletalRepository.save(entity);
    }

    @SneakyThrows
    public void deleteMusculoskeletal(Integer id){

        musculoskeletalRepository.findById(id).orElseThrow(() -> new NotFoundException("Musculoskeletal identified by id:{"+id+"} was not found."));
        musculoskeletalRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateMusculoskeletal(Musculoskeletal entity) {

        Musculoskeletal setEntity = musculoskeletalRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Musculoskeletal identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        musculoskeletalRepository.save(setEntity);

    }
}
