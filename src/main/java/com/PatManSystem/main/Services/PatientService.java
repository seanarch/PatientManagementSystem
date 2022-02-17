package com.PatManSystem.main.Services;


import com.PatManSystem.main.Models.Patient;
import java.util.List;

import com.PatManSystem.main.Models.PtId;
import com.PatManSystem.main.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Connor
 */
@Service
public class PatientService{

    @Autowired
    private PatientRepository  studentRepository;

    public List<PtId> getPatients(){
        return studentRepository.findAll();
    }

}
