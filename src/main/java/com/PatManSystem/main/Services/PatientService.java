package com.PatManSystem.main.Services;


import com.PatManSystem.main.Models.Patient;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Connor
 */
@Service
public class PatientService {
    public List<Patient> getPatients(){      
            return List.of(
                    new Patient(
                            123456,
                            "firstname", 
                            "lastname"
                    )
            );  
        } 
}
