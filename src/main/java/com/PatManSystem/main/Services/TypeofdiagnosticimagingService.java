package com.PatManSystem.main.Services;

import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Typeofdiagnosticimaging;
import com.PatManSystem.main.Repository.TypeofdiagnosticimagingRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeofdiagnosticimagingService {


    private final TypeofdiagnosticimagingRepository typeofdiagnosticimagingRepository;

    @Autowired
    public TypeofdiagnosticimagingService(TypeofdiagnosticimagingRepository typeofdiagnosticimagingRepository){
        this.typeofdiagnosticimagingRepository = typeofdiagnosticimagingRepository;
    }

    public List<Typeofdiagnosticimaging> getTypeofdiagnosticimagings(){
        return typeofdiagnosticimagingRepository.findAll();
    }
    @SneakyThrows
    public Typeofdiagnosticimaging getTypeofdiagnosticimaging(Integer id){
        return typeofdiagnosticimagingRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofdiagnosticimaging identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newTypeofdiagnosticimaging(Typeofdiagnosticimaging entity){

        if (entity.getId() != null && typeofdiagnosticimagingRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Typeofdiagnosticimaging identified by ID:{" + entity.getId() + "} already exists.");

        typeofdiagnosticimagingRepository.save(entity);
    }

    @SneakyThrows
    public void deleteTypeofdiagnosticimaging(Integer id){

        typeofdiagnosticimagingRepository.findById(id).orElseThrow(() -> new NotFoundException("Typeofdiagnosticimaging identified by id:{"+id+"} was not found."));
        typeofdiagnosticimagingRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateTypeofdiagnosticimaging(Typeofdiagnosticimaging entity) {

        Typeofdiagnosticimaging setEntity = typeofdiagnosticimagingRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Typeofdiagnosticimaging identified by id:{" + entity.getId() + "} was not found."));

        if (entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        typeofdiagnosticimagingRepository.save(setEntity);

    }
}
