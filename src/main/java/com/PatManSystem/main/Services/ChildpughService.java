package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ChildpughDTO;
import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Mapper.AssessMapperImpl;
import com.PatManSystem.main.Mapper.ChildpughMapperImpl;
import com.PatManSystem.main.Mapper.ExamMapperImpl;
import com.PatManSystem.main.Models.Childpugh;
import com.PatManSystem.main.Models.Exam;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.ChildpughRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChildpughService {

    private final ChildpughRepository childpughRepository;

    @Autowired
    public ChildpughService(ChildpughRepository childpughRepository){
        this.childpughRepository = childpughRepository;
    }


    public List<ChildpughDTO> getChildpughs(){
        return childpughRepository.findAll()
                .stream()
                .map(new ChildpughMapperImpl()::childpughToChildpughDTO)
                .collect(Collectors.toList());
    }
    @SneakyThrows
    public ChildpughDTO getChildpugh(Integer id) {
        return new ChildpughMapperImpl().childpughToChildpughDTO(childpughRepository.findById(id).orElseThrow(() -> new ChildPughNotFound(id)));
    }
    @SneakyThrows
    public void newChildpugh(ChildpughDTO childpughDTO){

        if(childpughRepository.findById(childpughDTO.getId()).isPresent())
           throw new ChildPughDuplicateFound(childpughDTO.getId()); //find the entity by its id, if it is be found throw a DuplicateFound exception, otherwise continue

        childpughRepository.save(new ChildpughMapperImpl().childpughDTOToChildpugh(childpughDTO)); // convert incoming DTO to DB entity and save to the DB

    }
    @SneakyThrows
    public void deleteChildpugh(Integer id){

        childpughRepository.findById(id).orElseThrow(() -> new ChildPughNotFound(id)); //find the entity by its id, if it cannot be found throw a NotFound exception, otherwise continue
        childpughRepository.deleteById(id);

    }
    public void updateChildpugh(ChildpughDTO DTO){

    }
    /*Custom exceptions for this class
    * NotFound
    * DuplicateFound
    * */
    static class ChildPughNotFound extends Exception{
        public ChildPughNotFound(String errorMessage){
            super(errorMessage);
        }
        public ChildPughNotFound(){
            super("Childpugh not found");
        }
        public ChildPughNotFound(Integer id){
            super("Childpugh of ID:"+id+" not found");
        }
    }
    static class ChildPughDuplicateFound extends Exception{
        public ChildPughDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public ChildPughDuplicateFound(){
            super("Childpugh already exists");
        }
        public ChildPughDuplicateFound(Integer id){
            super("Childpugh of ID:"+id+" already exists");
        }
    }
}
