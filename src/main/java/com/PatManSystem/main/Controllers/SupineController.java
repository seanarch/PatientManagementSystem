package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Supine;
import com.PatManSystem.main.Services.SupineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/supine",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class SupineController {

    private final SupineService supineService;

    @Autowired
    public SupineController(SupineService supineService) {
        this.supineService = supineService;
    }

    @GetMapping(path = "/all")
    public List<Supine> getSupine() {return supineService.getSupines();
    }

    @GetMapping(path ="/id={id}")
    public Supine getSupine(@PathVariable("id") Integer id){
        return supineService.getSupine(id);
    }

    @PostMapping(path = "/new")
    public String registerNewSupine(@RequestBody Supine supine){
        supineService.newSupine(supine);
        return "NEW: Supine identified by ID "+supine.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteSupine(@PathVariable("id") Integer id){
        supineService.deleteSupine(id);
        return "DELETE: Supine identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateSupine(@RequestBody Supine supine){

        supineService.updateSupine(supine);
        return "UPDATE: Supine identified by ID "+supine.getId()+" successfully updated.";

    }
}