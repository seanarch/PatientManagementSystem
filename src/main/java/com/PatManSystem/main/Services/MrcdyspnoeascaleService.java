package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Mrcdyspnoeascale;
import com.PatManSystem.main.Repository.MrcdyspnoeascaleRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MrcdyspnoeascaleService {


    private final MrcdyspnoeascaleRepository mrcdyspnoeascaleRepository;

    @Autowired
    public MrcdyspnoeascaleService(MrcdyspnoeascaleRepository mrcdyspnoeascaleRepository){
        this.mrcdyspnoeascaleRepository = mrcdyspnoeascaleRepository;
    }

    public List<Mrcdyspnoeascale> getMrcdyspnoeascales(){
        return mrcdyspnoeascaleRepository.findAll();
    }
    @SneakyThrows
    public Mrcdyspnoeascale getMrcdyspnoeascale(Integer id){
        return mrcdyspnoeascaleRepository.findById(id).orElseThrow(() -> new NotFoundException("Mrcdyspnoeascale identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newMrcdyspnoeascale(Mrcdyspnoeascale entity){

        if (entity.getId() != null && mrcdyspnoeascaleRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Mrcdyspnoeascale identified by ID:{" + entity.getId() + "} already exists.");

        mrcdyspnoeascaleRepository.save(entity);
    }

    @SneakyThrows
    public void deleteMrcdyspnoeascale(Integer id){

        mrcdyspnoeascaleRepository.findById(id).orElseThrow(() -> new NotFoundException("Mrcdyspnoeascale identified by id:{"+id+"} was not found."));
        mrcdyspnoeascaleRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateMrcdyspnoeascale(Mrcdyspnoeascale entity) {

        Mrcdyspnoeascale setEntity = mrcdyspnoeascaleRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Mrcdyspnoeascale identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        mrcdyspnoeascaleRepository.save(setEntity);

    }
}