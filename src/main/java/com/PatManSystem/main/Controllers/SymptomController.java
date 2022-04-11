package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.SymptomDTO;
import com.PatManSystem.main.Services.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/symptom",
        method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class SymptomController {

    private final SymptomService symptomService;

    @Autowired
    public SymptomController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @GetMapping(path = "/all")
    public List<SymptomDTO> getSymptom() {return symptomService.getSymptoms();
    }

    @GetMapping(path ="/id={id}")
    public SymptomDTO getSymptom(@PathVariable("id") Integer id){
        return symptomService.getSymptom(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<SymptomDTO> getSymptoms(@PathVariable("ULI") Long ULI){
        return symptomService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewSymptom(@RequestBody SymptomDTO symptomDTO){

        symptomService.newSymptom(symptomDTO);
        return "NEW: Symptom identified by ID "+symptomDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteSymptom(@PathVariable("id") Integer id){
        symptomService.deleteSymptom(id);
        return "DELETE: Symptom identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateSymptom(@RequestBody SymptomDTO symptomDTO){

        symptomService.updateSymptom(symptomDTO);
        return "UPDATE: Symptom identified by ID "+symptomDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateSymptom(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) Integer symptomId,
            @RequestParam(required = false) String detail
    ){
        symptomService.updateSymptom(new SymptomDTO(id,symptomId,detail));

        return "UPDATE: Symptom identified by ID "+id+" successfully updated.";
    }

}
