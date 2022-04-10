package com.PatManSystem.main.Services;



import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Models.Abdomen;
import com.PatManSystem.main.Repository.AbdomenRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class AbdomenService {


    private final AbdomenRepository abdomenRepository;

    @Autowired
    public AbdomenService(AbdomenRepository abdomenRepository){
        this.abdomenRepository = abdomenRepository;
    }

    public List<Abdomen> getAbdomens(){
        return abdomenRepository.findAll();
    }
    @SneakyThrows
    public Abdomen getAbdomen(Integer id){
        return abdomenRepository.findById(id).orElseThrow(() -> new NotFoundException("Abdomen identified by id:{"+id+"} was not found."));
    }

    @SneakyThrows
    public void newAbdomen(Abdomen entity){

        if(entity.getId() != null && abdomenRepository.findById(entity.getId()).isPresent())
            throw new DuplicateFoundException("Abdomen identified by ID:{"+entity.getId()+"} already exists.");

        abdomenRepository.save(entity);
    }

    @SneakyThrows
    public void deleteAbdomen(Integer id){

        abdomenRepository.findById(id).orElseThrow(() -> new NotFoundException("Abdomen identified by id:{"+id+"} was not found."));
        abdomenRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateAbdomen(Abdomen entity){

        Abdomen setEntity = abdomenRepository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Abdomen identified by id:{"+entity.getId()+"} was not found."));

        if(entity.getDescription() != null)
            setEntity.setDescription(entity.getDescription());

        abdomenRepository.save(setEntity);

    }
}
