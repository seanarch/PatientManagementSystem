package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Centralnervoussystem;
import com.PatManSystem.main.Services.CentralnervoussystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/centralnervoussystem" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class CentralnervoussystemController {

    private final CentralnervoussystemService centralnervoussystemService;

    @Autowired
    public CentralnervoussystemController(CentralnervoussystemService centralnervoussystemService) {
        this.centralnervoussystemService = centralnervoussystemService;
    }

    @GetMapping(path = "/all")
    public List<Centralnervoussystem> getCentralnervoussystem() {return centralnervoussystemService.getCentralnervoussystems();
    }

    @GetMapping(path ="/id={id}")
    public Centralnervoussystem getCentralnervoussystem(@PathVariable("id") Integer id){
        return centralnervoussystemService.getCentralnervoussystem(id);
    }

    @PostMapping(path = "/new")
    public String registerNewCentralnervoussystem(@RequestBody Centralnervoussystem centralnervoussystem){
        centralnervoussystemService.newCentralnervoussystem(centralnervoussystem);
        return "NEW: Centralnervoussystem identified by ID "+centralnervoussystem.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteCentralnervoussystem(@PathVariable("id") Integer id){
        centralnervoussystemService.deleteCentralnervoussystem(id);
        return "DELETE: Centralnervoussystem identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateCentralnervoussystem(@RequestBody Centralnervoussystem centralnervoussystem){

        centralnervoussystemService.updateCentralnervoussystem(centralnervoussystem);
        return "UPDATE: Centralnervoussystem identified by ID "+centralnervoussystem.getId()+" successfully updated.";

    }
}
