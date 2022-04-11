package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofmanagement;
import com.PatManSystem.main.Services.TypeofmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofmanagement",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class TypeofmanagementController {

    private final TypeofmanagementService typeofmanagementService;

    @Autowired
    public TypeofmanagementController(TypeofmanagementService typeofmanagementService) {
        this.typeofmanagementService = typeofmanagementService;
    }

    @GetMapping(path = "/all")
    public List<Typeofmanagement> getTypeofmanagement() {return typeofmanagementService.getTypeofmanagements();
    }

    @GetMapping(path ="/id={id}")
    public Typeofmanagement getTypeofmanagement(@PathVariable("id") Integer id){
        return typeofmanagementService.getTypeofmanagement(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofmanagement(@RequestBody Typeofmanagement typeofmanagement){
        typeofmanagementService.newTypeofmanagement(typeofmanagement);
        return "NEW: Typeofmanagement identified by ID "+typeofmanagement.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofmanagement(@PathVariable("id") Integer id){
        typeofmanagementService.deleteTypeofmanagement(id);
        return "DELETE: Typeofmanagement identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofmanagement(@RequestBody Typeofmanagement typeofmanagement){

        typeofmanagementService.updateTypeofmanagement(typeofmanagement);
        return "UPDATE: Typeofmanagement identified by ID "+typeofmanagement.getId()+" successfully updated.";

    }
}
