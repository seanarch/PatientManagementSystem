package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Ecogperformancestatusscale;
import com.PatManSystem.main.Repository.EcogperformancestatusscaleRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class EcogperformancestatusscaleService {


    private final EcogperformancestatusscaleRepository ecogperformancestatusscaleRepository;

    @Autowired
    public EcogperformancestatusscaleService(EcogperformancestatusscaleRepository ecogperformancestatusscaleRepository){
        this.ecogperformancestatusscaleRepository = ecogperformancestatusscaleRepository;
    }

    public List<Ecogperformancestatusscale> getEcogperformancestatusscales(){
        return ecogperformancestatusscaleRepository.findAll();
    }
    @SneakyThrows
    public Ecogperformancestatusscale getEcogperformancestatusscale(Integer id){
        return ecogperformancestatusscaleRepository.findById(id).orElseThrow(() -> new NotFoundException("Ecogperformancestatusscale identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newEcogperformancestatusscale(Ecogperformancestatusscale entity){

        if(entity.getId() != null && ecogperformancestatusscaleRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Ecogperformancestatusscale identified by ID:{"+entity.getId()+"} already exists.");

        ecogperformancestatusscaleRepository.save(entity);
    }

    @SneakyThrows
    public void deleteEcogperformancestatusscale(Integer id){

        ecogperformancestatusscaleRepository.findById(id).orElseThrow(() -> new NotFoundException("Ecogperformancestatusscale identified by id:{"+id+"} was not found."));
        ecogperformancestatusscaleRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateEcogperformancestatusscale(Ecogperformancestatusscale entity){

        Ecogperformancestatusscale setEntity = ecogperformancestatusscaleRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Ecogperformancestatusscale identified by id:{"+entity.getId()+"} was not found."));

        if(entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        ecogperformancestatusscaleRepository.save(setEntity);

    }
}
