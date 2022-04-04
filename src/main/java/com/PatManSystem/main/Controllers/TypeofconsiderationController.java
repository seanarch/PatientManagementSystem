package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofconsideration;
import com.PatManSystem.main.Services.TypeofconsiderationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofconsideration" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class TypeofconsiderationController {

    private final TypeofconsiderationService typeofconsiderationService;

    @Autowired
    public TypeofconsiderationController(TypeofconsiderationService typeofconsiderationService) {
        this.typeofconsiderationService = typeofconsiderationService;
    }

    @GetMapping(path = "/all")
    public List<Typeofconsideration> getTypeofconsideration() {return typeofconsiderationService.getTypeofconsiderations();
    }

    @GetMapping(path ="/id={id}")
    public Typeofconsideration getTypeofconsideration(@PathVariable("id") Integer id){
        return typeofconsiderationService.getTypeofconsideration(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofconsideration(@RequestBody Typeofconsideration typeofconsideration){
        typeofconsiderationService.newTypeofconsideration(typeofconsideration);
        return "NEW: Typeofconsideration identified by ID "+typeofconsideration.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofconsideration(@PathVariable("id") Integer id){
        typeofconsiderationService.deleteTypeofconsideration(id);
        return "DELETE: Typeofconsideration identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofconsideration(@RequestBody Typeofconsideration typeofconsideration){

        typeofconsiderationService.updateTypeofconsideration(typeofconsideration);
        return "UPDATE: Typeofconsideration identified by ID "+typeofconsideration.getId()+" successfully updated.";

    }
}
