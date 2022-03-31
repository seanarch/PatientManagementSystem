package com.PatManSystem.main.Services;


import com.PatManSystem.main.DTO.NewpatientconsultDTO;
import com.PatManSystem.main.Mapper.NewpatientconsultMapperImpl;
import com.PatManSystem.main.Models.Newpatientconsult;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.NewpatientconsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewpatientconsultService {


    private NewpatientconsultRepository newpatientconsultRepository;

    @Autowired
    public NewpatientconsultService(NewpatientconsultRepository newpatientconsultRepository) {
        this.newpatientconsultRepository = newpatientconsultRepository;
    }

    public List<NewpatientconsultDTO> getNewpatientconsults() {
        return newpatientconsultRepository.findAll()
                .stream()
                .map(newpatientconsult -> {
                    return new NewpatientconsultMapperImpl().newpatientconsultToNewpatientconsultDTO(newpatientconsult);
                })
                .collect(Collectors.toList());
    }

    //find Newpatientconsult entity by id and return NewpatientconsultDTO
    public NewpatientconsultDTO getNewpatientconsult(Long id) {
        Newpatientconsult getNewpatientconsult = newpatientconsultRepository.findNewpatientconsultById(id);
        if (getNewpatientconsult == null)
            throw new IllegalStateException("Newpatientconsult identified by ID " + id + " was not found.");

        return new NewpatientconsultMapperImpl().newpatientconsultToNewpatientconsultDTO(getNewpatientconsult);
    }

    //find Newpatientconsult entity by ULI and return NewpatientconsultDTO list
    public List<NewpatientconsultDTO> getNewpatientconsultByULI(Long ULI){
        List<Newpatientconsult> getNewpatientconsults = newpatientconsultRepository.findNewpatientconsultByUli(new Patientinformation(ULI,null,null,null,null,null,null,null));
        if (getNewpatientconsults == null)
            throw new IllegalStateException("Newpatientconsult identified by ULI "+ULI+" was not found.");

        return getNewpatientconsults.stream()
                .map(newpatientconsult -> new NewpatientconsultMapperImpl().newpatientconsultToNewpatientconsultDTO(newpatientconsult))
                .collect(Collectors.toList());
    }

    //create new Newpatientconsult entity by passing NewpatientconsultDTO
    public void newNewpatientconsult(NewpatientconsultDTO newpatientconsultDTO) {
        if (newpatientconsultRepository.findNewpatientconsultById(newpatientconsultDTO.getId()) != null) {
            throw new IllegalStateException("Newpatientconsult identified by ID " + newpatientconsultDTO.getId() + " already exists. Use Post:Update at /api/newpatientconsult/update instead.");
        }
        newpatientconsultRepository.save(new NewpatientconsultMapperImpl().newpatientconsultDTOToNewpatientconsult(newpatientconsultDTO));
    }

    //delete Newpatientconsult entity by id
    public void deleteNewpatientconsult(Long id) {
        if (newpatientconsultRepository.findNewpatientconsultById(id) == null) {
            throw new IllegalStateException("Newpatientconsult identified by ID " + id + " does not exist.");
        } else {
            newpatientconsultRepository.deleteById(id);
        }
    }

    //update Newpatientconsult entity
    public void updateNewpatientconsult(NewpatientconsultDTO newpatientconsultDTO) {
        Newpatientconsult existingNewpatientconsult = newpatientconsultRepository.findNewpatientconsultById(newpatientconsultDTO.getId());

        if (existingNewpatientconsult == null)
            throw new IllegalStateException("Newpatientconsult identified by ID " + newpatientconsultDTO.getId() + " was not found.");
        else {
            // newpatientconsult table's id may not need to be updated once it has been created
           /*
            if (newpatientconsultDTO.getId() != null) {
                existingNewpatientconsult.setId(newpatientconsultDTO.getId());
            }
            */
            if (newpatientconsultDTO.getDate() != null) {
                existingNewpatientconsult.setDate(newpatientconsultDTO.getDate());

                newpatientconsultRepository.save(existingNewpatientconsult);
            }
        }
    }
}