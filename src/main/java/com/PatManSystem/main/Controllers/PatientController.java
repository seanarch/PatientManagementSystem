package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Patient;
import com.PatManSystem.main.Models.PtId;
import com.PatManSystem.main.Services.PatientService;
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
@RequestMapping(path = "api/patient/")
@CrossOrigin("*")
public class PatientController {
    private final PatientService patientService;
    
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PtId> getPatients(){
        return patientService.getPatients();
    }
}
