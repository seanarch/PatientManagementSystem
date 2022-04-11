package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofrecure;
import com.PatManSystem.main.Services.TypeofrecureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofrecure",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class TypeofrecureController {

    private final TypeofrecureService typeofrecureService;

    @Autowired
    public TypeofrecureController(TypeofrecureService typeofrecureService) {
        this.typeofrecureService = typeofrecureService;
    }

    @GetMapping(path = "/all")
    public List<Typeofrecure> getTypeofrecure() {return typeofrecureService.getTypeofrecures();
    }

    @GetMapping(path ="/id={id}")
    public Typeofrecure getTypeofrecure(@PathVariable("id") Integer id){
        return typeofrecureService.getTypeofrecure(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofrecure(@RequestBody Typeofrecure typeofrecure){
        typeofrecureService.newTypeofrecure(typeofrecure);
        return "NEW: Typeofrecure identified by ID "+typeofrecure.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofrecure(@PathVariable("id") Integer id){
        typeofrecureService.deleteTypeofrecure(id);
        return "DELETE: Typeofrecure identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofrecure(@RequestBody Typeofrecure typeofrecure){

        typeofrecureService.updateTypeofrecure(typeofrecure);
        return "UPDATE: Typeofrecure identified by ID "+typeofrecure.getId()+" successfully updated.";

    }
}