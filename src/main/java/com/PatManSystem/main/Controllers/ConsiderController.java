package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.ConsiderDTO;
import com.PatManSystem.main.Services.ConsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/consider")
@CrossOrigin("*")
public class ConsiderController {

    private final ConsiderService considerService;

    @Autowired
    public ConsiderController(ConsiderService considerService) {
        this.considerService = considerService;
    }

    @GetMapping(path = "/all")
    public List<ConsiderDTO> getConsider() {return considerService.getConsiders();
    }

    @GetMapping(path ="/id={id}")
    public ConsiderDTO getConsider(@PathVariable("id") Integer id){
        return considerService.getConsider(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<ConsiderDTO> getConsiders(@PathVariable("ULI") Long ULI){
        return considerService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewConsider(@RequestBody ConsiderDTO considerDTO){

        considerService.newConsider(considerDTO);
        return "NEW: Consider identified by ID "+considerDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteConsider(@PathVariable("id") Integer id){
        considerService.deleteConsider(id);
        return "DELETE: Consider identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateConsider(@RequestBody ConsiderDTO considerDTO){

        considerService.updateConsider(considerDTO);
        return "UPDATE: Consider identified by ID "+considerDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateConsider(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) Integer considerId,
            @RequestParam(required = false) String considerDescription,
            @RequestParam(required = false) String detail
    ){
        considerService.updateConsider(new ConsiderDTO(id,considerId,considerDescription,detail));

        return "UPDATE: Consider identified by ID "+id+" successfully updated.";
    }
    
}
