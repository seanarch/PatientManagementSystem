package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Services.PatientInformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Connor
 */

@RestController  
@RequestMapping(path = "/api/patient")
@CrossOrigin("*")
public class PatientController {
    private final PatientInformationService patientService;
    
    @Autowired
    public PatientController(PatientInformationService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path ="/all")
    public List<Patientinformation> getPatients(){
        return patientService.getPatients();
    }


}
