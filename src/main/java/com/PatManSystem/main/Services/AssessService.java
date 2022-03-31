package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.AssessDTO;
import com.PatManSystem.main.DTO.AssessDTO;
import com.PatManSystem.main.Mapper.AssessMapperImpl;
import com.PatManSystem.main.Mapper.AssessMapperImpl;
import com.PatManSystem.main.Models.Assess;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.AssessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssessService {

@Autowired
private AssessRepository assessRepository;

    public List<AssessDTO> getAssesss(){
        return assessRepository.findAll()
        .stream()
        .map(assess -> new AssessMapperImpl().assessToAssessDTO(assess))
        .collect(Collectors.toList());
    }
    public AssessDTO getAssess(Integer id){
        Optional<Assess> getAssess = assessRepository.findById(id);
        if(getAssess.isPresent()) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Assess identified by ID "+id+" was not found.");

        return new AssessMapperImpl().assessToAssessDTO(getAssess.get());

    }
    public List<AssessDTO> getAssessByULI(Long ULI){

        List<Assess> getAssesss = assessRepository.findAssessByUli(new Patientinformation(ULI,null,null,null,null,null,null,null));
        if(getAssesss == null) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Assess identified by ULI "+ULI+" was not found.");

        return getAssesss.stream()
                .map(assess -> new AssessMapperImpl().assessToAssessDTO(assess))
                .collect(Collectors.toList());

    }
    public void newAssess(AssessDTO assessDTO){

        if(assessRepository.findById(assessDTO.getId()).isPresent()){  //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Assess identified by ID "+assessDTO.getId() + " already exists. Use Post:Update at /api/patient/update instead.");
        }else{
            assessRepository.save(new AssessMapperImpl().assessDTOToAssess(assessDTO)); // convert incoming DTO to DB entity and save to the DB
        }

    }
    public void deleteAssess(Integer id){

        if(assessRepository.findById(id).isEmpty()){ //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Assess identified by ID "+id+ " does not exist.");
        }else{
            assessRepository.deleteById(id);
        }

    }
    @Transactional    // set all methods to be transactional, when a .set is called, it will create a DB transaction of the same type
    public void updateAssess(AssessDTO DTO){
        /*
            The following code is really hard to explain. Basically it dynamically maps the getters from the DTO
            to the setters of the DB entity. Using this technique this code is model agnostic and doesnt need to
            be modified for new models. To use this in other Service classes you need only change the repository
            type, and the DTO type. Specifically the Class type of entity and DTO
        */
        Assess entity = assessRepository.findById(DTO.getId()).get(); //retrieve a copy of the entity type

        if(entity != null)
            for (Method getter : DTO.getClass().getMethods()) {
                Object get = "";
                if (getter.getName().startsWith("get") && getter.getParameterTypes().length == 0) {
                    System.out.println("Getter: "+getter);

                    try {
                        get = getter.invoke(DTO);
                        System.out.println("Get: "+get);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    if (get != null)
                        for (Method setter : entity.getClass().getMethods()) {
                            if (setter.getName().startsWith("set") && setter.getName().endsWith(getter.getName().substring(3)) && setter.getParameterTypes().length == 1) {
                                try {
                                    setter.invoke(entity, get);
                                    System.out.println("Setter: "+setter);

                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                                continue;
                            }
                        }
                }
                System.out.println("----------");
            }
        else
            throw new IllegalStateException("Assess identified by ID "+DTO.getId()+ " does not exist.");
    }
}