package com.PatManSystem.main.Services;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.PatManSystem.main.DTO.PatientinformationDTO;
import com.PatManSystem.main.Mapper.PatientinformationMapper;
import com.PatManSystem.main.Mapper.PatientinformationMapperImpl;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.PatientRepository;
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
    public PatientinformationDTO getPatient(Long id){

        Patientinformation newPatient = patientRepository.findPatientinformationById(id);
        if(newPatient == null) //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Patient identified by ULI "+id+" was not found.");

        return new PatientinformationMapperImpl().patientinformationToPatientinformationDTO(newPatient);

    }
    public void newPatient(PatientinformationDTO patientinformationDTO){

        if(patientRepository.findPatientinformationById(patientinformationDTO.getId()) != null){  //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Patient identified by ULI "+patientinformationDTO.getId() + " already exists. Use Post:Update at /api/patient/update instead.");
        }else{
            patientRepository.save(new PatientinformationMapperImpl().patientinformationDTOToPatientinformation(patientinformationDTO)); // convert incoming DTO to DB entity and save to the DB
        }

    }

    public void deletePatient(Long id){

        if(patientRepository.findPatientinformationById(id) == null){ //check if the requested patient exists, if not; throw not found exception
            throw new IllegalStateException("Patient identified by ULI "+id+ " does not exist.");
        }else{
            patientRepository.deleteById(id);
        }

    }
    @Transactional // set all methods to be transactional, when a .set is called, it will create a DB transaction of the same type
    public void updatePatient(PatientinformationDTO patientinformationDTO){
        Patientinformation PI = patientRepository.findPatientinformationById(patientinformationDTO.getId()); //retrieve a copy of the Patientinfo
        /*
            The following code is really hard to explain. Basically it dynamically maps the getters from the DTO
            to the setters of the DB entity. Using this technique this code is model agnostic and doesnt need to
            be modified for new models. To use this in other Service classes you need only change the repository
            name and type, and the DTO name and type.
        */
        for (Method getter : patientinformationDTO.getClass().getMethods()) {
            Object get = "";
            if (getter.getName().startsWith("get") && getter.getParameterTypes().length == 0) {
                try {
                    get = getter.invoke(patientinformationDTO);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (get != null)
                    for (Method setter : PI.getClass().getMethods()) {
                        if (setter.getName().startsWith("set") && setter.getName().endsWith(getter.getName().substring(3)) && setter.getParameterTypes().length == 1) {
                            try {
                                setter.invoke(PI, get);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                            continue;
                        }
                    }
             }
        }
    }
}
