package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofhistoryofpresentillness;
import com.PatManSystem.main.Services.TypeofhistoryofpresentillnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofhistoryofpresentillness" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class TypeofhistoryofpresentillnessController {

    private final TypeofhistoryofpresentillnessService typeofhistoryofpresentillnessService;

    @Autowired
    public TypeofhistoryofpresentillnessController(TypeofhistoryofpresentillnessService typeofhistoryofpresentillnessService) {
        this.typeofhistoryofpresentillnessService = typeofhistoryofpresentillnessService;
    }

    @GetMapping(path = "/all")
    public List<Typeofhistoryofpresentillness> getTypeofhistoryofpresentillness() {return typeofhistoryofpresentillnessService.getTypeofhistoryofpresentillnesss();
    }

    @GetMapping(path ="/id={id}")
    public Typeofhistoryofpresentillness getTypeofhistoryofpresentillness(@PathVariable("id") Integer id){
        return typeofhistoryofpresentillnessService.getTypeofhistoryofpresentillness(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofhistoryofpresentillness(@RequestBody Typeofhistoryofpresentillness typeofhistoryofpresentillness){
        typeofhistoryofpresentillnessService.newTypeofhistoryofpresentillness(typeofhistoryofpresentillness);
        return "NEW: Typeofhistoryofpresentillness identified by ID "+typeofhistoryofpresentillness.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofhistoryofpresentillness(@PathVariable("id") Integer id){
        typeofhistoryofpresentillnessService.deleteTypeofhistoryofpresentillness(id);
        return "DELETE: Typeofhistoryofpresentillness identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofhistoryofpresentillness(@RequestBody Typeofhistoryofpresentillness typeofhistoryofpresentillness){

        typeofhistoryofpresentillnessService.updateTypeofhistoryofpresentillness(typeofhistoryofpresentillness);
        return "UPDATE: Typeofhistoryofpresentillness identified by ID "+typeofhistoryofpresentillness.getId()+" successfully updated.";

    }
}
