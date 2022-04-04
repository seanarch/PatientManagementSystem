package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.ChildpughDTO;
import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Services.ChildpughService;
import com.PatManSystem.main.Services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/childpugh" , method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class ChildpughController {

    private final ChildpughService childpughService;

    @Autowired
    public ChildpughController(ChildpughService childpughService) { this.childpughService = childpughService;}

    @GetMapping(path ="/all")
    public List<ChildpughDTO> getExams(){
        return childpughService.getChildpughs();
    }

    @GetMapping(path ="/id={id}")
    public ChildpughDTO getChildpugh(@PathVariable("id") Integer id){
        return childpughService.getChildpugh(id);
    }

    @PostMapping(path = "/new")
    public String createNewChildpugh(@RequestBody ChildpughDTO childpughDTO){
        childpughService.newChildpugh(childpughDTO);
        return "NEW: Childpugh identified by ID "+childpughDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteExam(@PathVariable("id") Integer id){
        childpughService.deleteChildpugh(id);
        return "DELETE: Childpugh identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateChildpugh(@RequestBody ChildpughDTO childpughDTO){

        childpughService.updateChildpugh(childpughDTO);
        return "UPDATE: Childpugh identified by ID "+childpughDTO.getId()+" successfully updated.";

    }

    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateChildPugh(
        @PathVariable("id") Integer id

    ){
        childpughService.updateChildpugh(new ChildpughDTO(id));
        return "UPDATE: Childpugh identified by ID "+id+" successfully updated.";
    }

}
