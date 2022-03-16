package com.PatManSystem.main.Services;


import java.util.List;

import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Connor
 */
@Service
public class PatientInformationService {

    @Autowired
    private PatientRepository  patientRepository;

    public List<Patientinformation> getPatients(){

        return patientRepository.findAll();

    }


}
