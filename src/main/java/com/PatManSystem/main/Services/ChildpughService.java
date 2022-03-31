package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ChildpughDTO;
import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Mapper.ChildpughMapperImpl;
import com.PatManSystem.main.Mapper.ExamMapperImpl;
import com.PatManSystem.main.Models.Childpugh;
import com.PatManSystem.main.Models.Exam;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.ChildpughRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChildpughService {

    @Autowired
    private ChildpughRepository childpughRepository;

    public List<ChildpughDTO> getChildpughs(){
        return childpughRepository.findAll()
                .stream()
                .map(childpugh -> {
                    return new ChildpughMapperImpl().childpughToChildpughDTO(childpugh);
                })
                .collect(Collectors.toList());
    }
    public ChildpughDTO getChildpugh(Integer id){

        Optional<Childpugh> getChildpugh = childpughRepository.findById(id);
        if(getChildpugh == null) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Childpugh identified by ID "+id+" was not found.");

        return new ChildpughMapperImpl().childpughToChildpughDTO(getChildpugh.get());
    }
    public void newChildpugh(ChildpughDTO childpughDTO){

        if(childpughRepository.findById(childpughDTO.getId()) != null){  //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Childpugh identified by ID "+childpughDTO.getId() + " already exists.");
        }else{
            childpughRepository.save(new ChildpughMapperImpl().childpughDTOToChildpugh(childpughDTO)); // convert incoming DTO to DB entity and save to the DB
        }

    }
    public void deleteChildpugh(Integer id){

        if(childpughRepository.findById(id) == null){ //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Childpugh identified by ID "+id+ " does not exist.");
        }else{
            childpughRepository.deleteById(id);
        }

    }
    public void updateChildpugh(ChildpughDTO DTO){

    }
}
