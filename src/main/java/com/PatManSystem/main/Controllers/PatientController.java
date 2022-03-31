package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.PatientinformationDTO;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Services.PatientInformationService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(path ="/id={id}")
    public PatientinformationDTO getPatient(@PathVariable("id") Long id){
        return patientService.getPatient(id);
    }

    @PostMapping(path = "/new")
    public String registerNewPatient(@RequestBody PatientinformationDTO patientinformationDTO){
        patientService.newPatient(patientinformationDTO);
        return "NEW: Patient identified by ULI "+patientinformationDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deletePatient(@PathVariable("id") Long id){
        patientService.deletePatient(id);
        return "DELETE: Patient identified by ULI "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updatePatient(@RequestBody PatientinformationDTO patientinformationDTO){
        patientService.updatePatient(patientinformationDTO);

        return "UPDATE: Patient identified by ULI "+patientinformationDTO.getId()+" successfully updated.";
    }

    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updatePatient(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) Character sex,
            @RequestParam(required = false) LocalDate birthday,
            @RequestParam(required = false) Integer print,
            @RequestParam(required = false) String tg,
            @RequestParam(required = false) String location
    ){
        patientService.updatePatient(new PatientinformationDTO(id,lastname,firstname,sex,birthday,print,tg,location));

        return "UPDATE: Patient identified by ULI "+id+" successfully updated.";
    }



}
