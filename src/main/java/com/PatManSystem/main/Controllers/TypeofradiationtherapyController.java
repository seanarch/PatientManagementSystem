package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofradiationtherapy;
import com.PatManSystem.main.Services.TypeofradiationtherapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofradiationtherapy" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class TypeofradiationtherapyController {

    private final TypeofradiationtherapyService typeofradiationtherapyService;

    @Autowired
    public TypeofradiationtherapyController(TypeofradiationtherapyService typeofradiationtherapyService) {
        this.typeofradiationtherapyService = typeofradiationtherapyService;
    }

    @GetMapping(path = "/all")
    public List<Typeofradiationtherapy> getTypeofradiationtherapy() {return typeofradiationtherapyService.getTypeofradiationtherapys();
    }

    @GetMapping(path ="/id={id}")
    public Typeofradiationtherapy getTypeofradiationtherapy(@PathVariable("id") Integer id){
        return typeofradiationtherapyService.getTypeofradiationtherapy(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofradiationtherapy(@RequestBody Typeofradiationtherapy typeofradiationtherapy){
        typeofradiationtherapyService.newTypeofradiationtherapy(typeofradiationtherapy);
        return "NEW: Typeofradiationtherapy identified by ID "+typeofradiationtherapy.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofradiationtherapy(@PathVariable("id") Integer id){
        typeofradiationtherapyService.deleteTypeofradiationtherapy(id);
        return "DELETE: Typeofradiationtherapy identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofradiationtherapy(@RequestBody Typeofradiationtherapy typeofradiationtherapy){

        typeofradiationtherapyService.updateTypeofradiationtherapy(typeofradiationtherapy);
        return "UPDATE: Typeofradiationtherapy identified by ID "+typeofradiationtherapy.getId()+" successfully updated.";

    }
}