package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofsymptom;
import com.PatManSystem.main.Services.TypeofsymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofsymptom" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class TypeofsymptomController {

    private final TypeofsymptomService typeofsymptomService;

    @Autowired
    public TypeofsymptomController(TypeofsymptomService typeofsymptomService) {
        this.typeofsymptomService = typeofsymptomService;
    }

    @GetMapping(path = "/all")
    public List<Typeofsymptom> getTypeofsymptom() {return typeofsymptomService.getTypeofsymptoms();
    }

    @GetMapping(path ="/id={id}")
    public Typeofsymptom getTypeofsymptom(@PathVariable("id") Integer id){
        return typeofsymptomService.getTypeofsymptom(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofsymptom(@RequestBody Typeofsymptom typeofsymptom){
        typeofsymptomService.newTypeofsymptom(typeofsymptom);
        return "NEW: Typeofsymptom identified by ID "+typeofsymptom.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofsymptom(@PathVariable("id") Integer id){
        typeofsymptomService.deleteTypeofsymptom(id);
        return "DELETE: Typeofsymptom identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofsymptom(@RequestBody Typeofsymptom typeofsymptom){

        typeofsymptomService.updateTypeofsymptom(typeofsymptom);
        return "UPDATE: Typeofsymptom identified by ID "+typeofsymptom.getId()+" successfully updated.";

    }
}
