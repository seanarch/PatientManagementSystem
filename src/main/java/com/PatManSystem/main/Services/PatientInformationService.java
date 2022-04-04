package com.PatManSystem.main.Services;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.PatManSystem.main.DTO.PatientinformationDTO;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.PatientinformationMapper;
import com.PatManSystem.main.Mapper.PatientinformationMapperImpl;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.PatientRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PatientInformationService {

    @Autowired
    private PatientRepository  patientRepository;



    public List<Patientinformation> getPatients(){

        return patientRepository.findAll(); // return a list of all patients

    }
    public PatientinformationDTO getPatient(Long ULI){

        Optional<Patientinformation> newPatient = patientRepository.findById(ULI);
        if(newPatient.isEmpty()) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Patient identified by ULI "+ULI+" was not found.");

        return new PatientinformationMapperImpl().patientinformationToPatientinformationDTO(newPatient.get());

    }
    public void newPatient(PatientinformationDTO patientinformationDTO){

        if(patientRepository.findById(patientinformationDTO.getId()).isPresent()){  //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Patient identified by ULI "+patientinformationDTO.getId() + " already exists. Use Post:Update at /api/patient/update instead.");
        }else{
            patientRepository.save(new PatientinformationMapperImpl().patientinformationDTOToPatientinformation(patientinformationDTO)); // convert incoming DTO to DB entity and save to the DB
        }

    }

    public void deletePatient(Long ULI){

        if(patientRepository.findById(ULI).isEmpty()){ //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Patient identified by ULI "+ULI+ " does not exist.");
        }else{
            patientRepository.deleteById(ULI);
        }

    }
    @SneakyThrows
    public void updatePatient(PatientinformationDTO DTO){
        Patientinformation setEntity = patientRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Patient identified by id:{"+DTO.getId()+"} was not found."));

        System.out.println(setEntity.getId());
        System.out.println(DTO.getLastname());
        System.out.println(setEntity.getLastname());
        if (DTO.getLastname() != null)
            setEntity.setLastname(DTO.getLastname());

        System.out.println(setEntity.getLastname());

        patientRepository.save(setEntity);
    }
}
