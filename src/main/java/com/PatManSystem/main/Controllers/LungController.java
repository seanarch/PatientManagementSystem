package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Lung;
import com.PatManSystem.main.Services.LungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/lung" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class LungController {

    private final LungService lungService;

    @Autowired
    public LungController(LungService lungService) {
        this.lungService = lungService;
    }

    @GetMapping(path = "/all")
    public List<Lung> getLung() {return lungService.getLungs();
    }

    @GetMapping(path ="/id={id}")
    public Lung getLung(@PathVariable("id") Integer id){
        return lungService.getLung(id);
    }

    @PostMapping(path = "/new")
    public String registerNewLung(@RequestBody Lung lung){
        lungService.newLung(lung);
        return "NEW: Lung identified by ID "+lung.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteLung(@PathVariable("id") Integer id){
        lungService.deleteLung(id);
        return "DELETE: Lung identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateLung(@RequestBody Lung lung){

        lungService.updateLung(lung);
        return "UPDATE: Lung identified by ID "+lung.getId()+" successfully updated.";

    }
}
