package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofdecision;
import com.PatManSystem.main.Services.TypeofdecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofdecision")
@CrossOrigin("*")
public class TypeofdecisionController {

    private final TypeofdecisionService typeofdecisionService;

    @Autowired
    public TypeofdecisionController(TypeofdecisionService typeofdecisionService) {
        this.typeofdecisionService = typeofdecisionService;
    }

    @GetMapping(path = "/all")
    public List<Typeofdecision> getTypeofdecision() {return typeofdecisionService.getTypeofdecisions();
    }

    @GetMapping(path ="/id={id}")
    public Typeofdecision getTypeofdecision(@PathVariable("id") Integer id){
        return typeofdecisionService.getTypeofdecision(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofdecision(@RequestBody Typeofdecision typeofdecision){
        typeofdecisionService.newTypeofdecision(typeofdecision);
        return "NEW: Typeofdecision identified by ID "+typeofdecision.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofdecision(@PathVariable("id") Integer id){
        typeofdecisionService.deleteTypeofdecision(id);
        return "DELETE: Typeofdecision identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofdecision(@RequestBody Typeofdecision typeofdecision){

        typeofdecisionService.updateTypeofdecision(typeofdecision);
        return "UPDATE: Typeofdecision identified by ID "+typeofdecision.getId()+" successfully updated.";

    }
}