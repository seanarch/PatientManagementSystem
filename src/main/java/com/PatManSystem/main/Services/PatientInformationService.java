package com.PatManSystem.main.Services;


import com.PatManSystem.main.DTO.PatientinformationDTO;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.PatientinformationMapperImpl;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.PatientRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientInformationService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientInformationService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patientinformation> getPatients() {

        return patientRepository.findAll(); // return a list of all patients

    }
    public PatientinformationDTO getPatient(Long ULI){

        Optional<Patientinformation> newPatient = patientRepository.findById(ULI);
        if(newPatient.isEmpty()) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Patient identified by ULI "+ULI+" was not found.");

        return new PatientinformationMapperImpl().patientinformationToPatientinformationDTO(newPatient.get());

    }
    public void newPatient(PatientinformationDTO patientinformationDTO){

        if (patientinformationDTO.getId() != null && patientRepository.existsById(patientinformationDTO.getId())) {  //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Patient identified by ULI " + patientinformationDTO.getId() + " already exists. Use Post:Update at /api/patient/update instead.");
        } else {
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

        if (DTO.getLastname() != null)
            setEntity.setLastname(DTO.getLastname());

        if (DTO.getFirstname() != null)
            setEntity.setFirstname(DTO.getFirstname());

        if (DTO.getSex() != null)
            setEntity.setSex(DTO.getSex());

        if (DTO.getBirthday() != null)
            setEntity.setBirthday(DTO.getBirthday());

        if (DTO.getPrint() != null)
            setEntity.setPrint(DTO.getPrint());

        if (DTO.getTg() != null)
            setEntity.setTg(DTO.getTg());

        if (DTO.getLocation() != null)
            setEntity.setLocation(DTO.getLocation());

        patientRepository.save(setEntity);
    }
}
