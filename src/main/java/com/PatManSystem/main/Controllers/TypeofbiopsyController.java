package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofbiopsy;
import com.PatManSystem.main.Services.TypeofbiopsyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofbiopsy" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class TypeofbiopsyController {

    private final TypeofbiopsyService typeofbiopsyService;

    @Autowired
    public TypeofbiopsyController(TypeofbiopsyService typeofbiopsyService) {
        this.typeofbiopsyService = typeofbiopsyService;
    }

    @GetMapping(path = "/all")
    public List<Typeofbiopsy> getTypeofbiopsy() {return typeofbiopsyService.getTypeofbiopsys();
    }

    @GetMapping(path ="/id={id}")
    public Typeofbiopsy getTypeofbiopsy(@PathVariable("id") Integer id){
        return typeofbiopsyService.getTypeofbiopsy(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofbiopsy(@RequestBody Typeofbiopsy typeofbiopsy){
        typeofbiopsyService.newTypeofbiopsy(typeofbiopsy);
        return "NEW: Typeofbiopsy identified by ID "+typeofbiopsy.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofbiopsy(@PathVariable("id") Integer id){
        typeofbiopsyService.deleteTypeofbiopsy(id);
        return "DELETE: Typeofbiopsy identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofbiopsy(@RequestBody Typeofbiopsy typeofbiopsy){

        typeofbiopsyService.updateTypeofbiopsy(typeofbiopsy);
        return "UPDATE: Typeofbiopsy identified by ID "+typeofbiopsy.getId()+" successfully updated.";

    }
}
