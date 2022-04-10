package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.DeathDTO;
import com.PatManSystem.main.Services.DeathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping(path = "/api/death" ,
        method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class DeathController {
    private final DeathService deathService;

    @Autowired
    public DeathController(DeathService deathService) {
        this.deathService = deathService;
    }

    @GetMapping(path = "/all")
    public List<DeathDTO> getDeath() {return deathService.getDeaths();
    }

    @GetMapping(path ="/id={id}")
    public DeathDTO getDeath(@PathVariable("id") Integer id){
        return deathService.getDeath(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<DeathDTO> getDeaths(@PathVariable("ULI") Long ULI){
        return deathService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewDeath(@RequestBody DeathDTO deathDTO){
        deathService.newDeath(deathDTO);
        return "NEW: Death successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteDeath(@PathVariable("id") Integer id){
        deathService.deleteDeath(id);
        return "DELETE: Death identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateDeath(@RequestBody DeathDTO deathDTO){

        deathService.updateDeath(deathDTO);
        return "UPDATE: Death identified by ID "+deathDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateDeath(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) String detail
    ){
        deathService.updateDeath(new DeathDTO(id,date,detail));

        return "UPDATE: Death identified by ID "+id+" successfully updated.";
    }
}
