package com.PatManSystem.main.Services;


import com.PatManSystem.main.DTO.NewpatientconsultDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
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
    public NewpatientconsultDTO getNewpatientconsult(Integer id) throws NotFoundException {
        Newpatientconsult getNewpatientconsult = newpatientconsultRepository.findNewpatientconsultById(id);
        if (getNewpatientconsult == null)
            throw new NotFoundException(id);

        return new NewpatientconsultMapperImpl().newpatientconsultToNewpatientconsultDTO(getNewpatientconsult);
    }

    //find Newpatientconsult entity by ULI and return NewpatientconsultDTO list
    public List<NewpatientconsultDTO> getNewpatientconsultByULI(Long ULI) throws NotFoundException {
        List<Newpatientconsult> getNewpatientconsults = newpatientconsultRepository.findNewpatientconsultByUli(new Patientinformation(ULI,null,null,null,null,null,null,null));
        if (getNewpatientconsults.isEmpty())
            throw new NotFoundException(ULI);

        return getNewpatientconsults.stream()
                .map(newpatientconsult -> new NewpatientconsultMapperImpl().newpatientconsultToNewpatientconsultDTO(newpatientconsult))
                .collect(Collectors.toList());
    }

    //create new Newpatientconsult entity by passing NewpatientconsultDTO
    public void newNewpatientconsult(NewpatientconsultDTO newpatientconsultDTO) throws DuplicateFoundException {
        if (newpatientconsultRepository.findNewpatientconsultById(newpatientconsultDTO.getId()) != null) {
            throw new DuplicateFoundException(newpatientconsultDTO.getId());
        }
        newpatientconsultRepository.save(new NewpatientconsultMapperImpl().newpatientconsultDTOToNewpatientconsult(newpatientconsultDTO));
    }

    //delete Newpatientconsult entity by id
    public void deleteNewpatientconsult(Integer id) throws NotFoundException {
        if (newpatientconsultRepository.findNewpatientconsultById(id) == null) {
            throw new NotFoundException(id);
        } else {
            newpatientconsultRepository.deleteById(id);
        }
    }

    //update Newpatientconsult entity
    public void updateNewpatientconsult(NewpatientconsultDTO newpatientconsultDTO) throws NotFoundException {
        Newpatientconsult existingNewpatientconsult = newpatientconsultRepository.findNewpatientconsultById(newpatientconsultDTO.getId());

        if (existingNewpatientconsult == null)
            throw new NotFoundException(newpatientconsultDTO.getId());
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