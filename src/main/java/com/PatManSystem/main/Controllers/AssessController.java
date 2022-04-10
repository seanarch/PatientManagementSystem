package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.AssessDTO;
import com.PatManSystem.main.DTO.AssessDTO;
import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Services.AssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/assess",
        method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class AssessController {

    private final AssessService assessService;

    @Autowired
    public AssessController(AssessService assessService) {
        this.assessService = assessService;
    }

    @GetMapping(path = "/all")
    public List<AssessDTO> getAssess() {return assessService.getAssesss();
    }

    @GetMapping(path ="/id={id}")
    public AssessDTO getAssess(@PathVariable("id") Integer id){
        return assessService.getAssess(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<AssessDTO> getAssesss(@PathVariable("ULI") Long ULI){
        return assessService.getAssessByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewAssess(@RequestBody AssessDTO assessDTO){
        assessService.newAssess(assessDTO);
        return "NEW: Assess successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteAssess(@PathVariable("id") Integer id){
        assessService.deleteAssess(id);
        return "DELETE: Assess identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateAssess(@RequestBody AssessDTO assessDTO){

        assessService.updateAssess(assessDTO);
        return "UPDATE: Assess identified by ID "+assessDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateAssess(
        @PathVariable("id") Integer id,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, // date parsed from JSON is STRING, addition formatting required to convert to LocalDate Obj
        @RequestParam(required = false) Integer ecogId,
        @RequestParam(required = false) Integer swallowingId,
        @RequestParam(required = false) Integer breathingId
    ){
        assessService.updateAssess(new AssessDTO(id,date,ecogId,swallowingId,breathingId));

        return "UPDATE: Assess identified by ID "+id+" successfully updated.";
    }
    
}