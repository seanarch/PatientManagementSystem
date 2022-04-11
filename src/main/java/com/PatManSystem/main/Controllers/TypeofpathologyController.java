package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofpathology;
import com.PatManSystem.main.Services.TypeofpathologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofpathology",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class TypeofpathologyController {

    private final TypeofpathologyService typeofpathologyService;

    @Autowired
    public TypeofpathologyController(TypeofpathologyService typeofpathologyService) {
        this.typeofpathologyService = typeofpathologyService;
    }

    @GetMapping(path = "/all")
    public List<Typeofpathology> getTypeofpathology() {return typeofpathologyService.getTypeofpathologys();
    }

    @GetMapping(path ="/id={id}")
    public Typeofpathology getTypeofpathology(@PathVariable("id") Integer id){
        return typeofpathologyService.getTypeofpathology(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofpathology(@RequestBody Typeofpathology typeofpathology){
        typeofpathologyService.newTypeofpathology(typeofpathology);
        return "NEW: Typeofpathology identified by ID "+typeofpathology.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofpathology(@PathVariable("id") Integer id){
        typeofpathologyService.deleteTypeofpathology(id);
        return "DELETE: Typeofpathology identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofpathology(@RequestBody Typeofpathology typeofpathology){

        typeofpathologyService.updateTypeofpathology(typeofpathology);
        return "UPDATE: Typeofpathology identified by ID "+typeofpathology.getId()+" successfully updated.";

    }
}
