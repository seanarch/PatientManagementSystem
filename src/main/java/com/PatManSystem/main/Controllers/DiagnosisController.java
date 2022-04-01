package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.DiagnosisDTO;
import com.PatManSystem.main.Services.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/diagnosis")
@CrossOrigin("*")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @GetMapping(path = "/all")
    public List<DiagnosisDTO> getDiagnosis() {return diagnosisService.getDiagnosiss();
    }

    @GetMapping(path ="/id={id}")
    public DiagnosisDTO getDiagnosis(@PathVariable("id") Integer id){
        return diagnosisService.getDiagnosis(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<DiagnosisDTO> getDiagnosiss(@PathVariable("ULI") Long ULI){
        return diagnosisService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO){

        diagnosisService.newDiagnosis(diagnosisDTO);
        return "NEW: Diagnosis identified by ID "+diagnosisDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteDiagnosis(@PathVariable("id") Integer id){
        diagnosisService.deleteDiagnosis(id);
        return "DELETE: Diagnosis identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO){

        diagnosisService.updateDiagnosis(diagnosisDTO);
        return "UPDATE: Diagnosis identified by ID "+diagnosisDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateDiagnosis(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String nodesVe,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate oRDate,
            @RequestParam(required = false) Integer locationId,
            @RequestParam(required = false) Integer orId,
            @RequestParam(required = false) Integer sizePrimaryMm,
            @RequestParam(required = false) Integer pathologyId,
            @RequestParam(required = false) String grade,
            @RequestParam(required = false) String margin,
            @RequestParam(required = false) Integer lvsi,
            @RequestParam(required = false) Integer periNeural,
            @RequestParam(required = false) String t,
            @RequestParam(required = false) String nodesTaken,
            @RequestParam(required = false) String n,
            @RequestParam(required = false) String m,
            @RequestParam(required = false) String stainingVeIHC,
            @RequestParam(required = false) String stage,
            @RequestParam(required = false) Integer recurId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate today
    ){
        diagnosisService.updateDiagnosis(
                new DiagnosisDTO(
                        id,
                        nodesVe,
                        oRDate,
                        locationId,
                        orId,
                        sizePrimaryMm,
                        pathologyId,
                        grade,
                        margin,
                        lvsi,
                        periNeural,
                        t,
                        nodesTaken,
                        n,
                        m,
                        stainingVeIHC,
                        stage,
                        recurId,
                        today));

        return "UPDATE: Diagnosis identified by ID "+id+" successfully updated.";
    }
}
