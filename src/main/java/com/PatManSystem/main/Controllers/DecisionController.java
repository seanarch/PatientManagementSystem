package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.DecisionDTO;
import com.PatManSystem.main.Services.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/decision")
@CrossOrigin("*")
public class DecisionController {

    private final DecisionService decisionService;

    @Autowired
    public DecisionController(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @GetMapping(path = "/all")
    public List<DecisionDTO> getDecision() {return decisionService.getDecisions();
    }

    @GetMapping(path ="/id={id}")
    public DecisionDTO getDecision(@PathVariable("id") Integer id){
        return decisionService.getDecision(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<DecisionDTO> getDecisions(@PathVariable("ULI") Long ULI){
        return decisionService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewDecision(@RequestBody DecisionDTO decisionDTO){

        decisionService.newDecision(decisionDTO);
        return "NEW: Decision identified by ID "+decisionDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteDecision(@PathVariable("id") Integer id){
        decisionService.deleteDecision(id);
        return "DELETE: Decision identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateDecision(@RequestBody DecisionDTO decisionDTO){

        decisionService.updateDecision(decisionDTO);
        return "UPDATE: Decision identified by ID "+decisionDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateDecision(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) Integer decisionId,
            @RequestParam(required = false) String detail
    ){
        decisionService.updateDecision(new DecisionDTO(id,decisionId,detail));

        return "UPDATE: Decision identified by ID "+id+" successfully updated.";
    }

}