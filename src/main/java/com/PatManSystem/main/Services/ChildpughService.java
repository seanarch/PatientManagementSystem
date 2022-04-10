package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ChildpughDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.ChildpughMapperImpl;
import com.PatManSystem.main.Models.Childpugh;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.ChildpughRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
        return new ChildpughMapperImpl().childpughToChildpughDTO(childpughRepository.findById(id).orElseThrow(() -> new NotFoundException("Childpugh identified by ID:{"+id+"} was not found.")));
    }
    @SneakyThrows
    public List<ChildpughDTO> getByULI(Long ULI){

        List<Childpugh> getChildpugh = childpughRepository.findByUli(new Patientinformation(ULI));

        if(getChildpugh.isEmpty())
            throw new NotFoundException("Childpugh identified by ULI:{"+ULI+"} was not found.");

        return getChildpugh.stream()
                .map(new ChildpughMapperImpl()::childpughToChildpughDTO)
                .collect(Collectors.toList());
    }
    @SneakyThrows
    public void newChildpugh(ChildpughDTO childpughDTO){

        if(childpughDTO.getId() != null && childpughRepository.existsById(childpughDTO.getId()))
           throw new DuplicateFoundException("Childpugh identified by ID:{"+childpughDTO.getId()+"} already exists."); //find the entity by its id, if it is be found throw a DuplicateFound exception, otherwise continue

        childpughRepository.save(new ChildpughMapperImpl().childpughDTOToChildpugh(childpughDTO)); // convert incoming DTO to DB entity and save to the DB

    }
    @SneakyThrows
    public void deleteChildpugh(Integer id){

        childpughRepository.findById(id).orElseThrow(() -> new NotFoundException("Childpugh identified by ID:{"+id+"} was not found.")); //find the entity by its id, if it cannot be found throw a NotFound exception, otherwise continue
        childpughRepository.deleteById(id);

    }
    @SneakyThrows
    public void updateChildpugh(ChildpughDTO DTO){

        Childpugh setEntity = childpughRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Childpugh identified by id:{"+DTO.getId()+"} was not found."));

        new ChildpughMapperImpl().updateChildpughFromChildpughDTO(DTO, setEntity);
        childpughRepository.save(setEntity);

    }

}
