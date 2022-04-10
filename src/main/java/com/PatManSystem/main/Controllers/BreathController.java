package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Breath;
import com.PatManSystem.main.Services.BreathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/breath" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class BreathController {

    private final BreathService breathService;

    @Autowired
    public BreathController(BreathService breathService) {
        this.breathService = breathService;
    }

    @GetMapping(path = "/all")
    public List<Breath> getBreath() {return breathService.getBreaths();
    }

    @GetMapping(path ="/id={id}")
    public Breath getBreath(@PathVariable("id") Integer id){
        return breathService.getBreath(id);
    }

    @PostMapping(path = "/new")
    public String registerNewBreath(@RequestBody Breath breath){
        breathService.newBreath(breath);
        return "NEW: Breath identified by ID "+breath.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteBreath(@PathVariable("id") Integer id){
        breathService.deleteBreath(id);
        return "DELETE: Breath identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateBreath(@RequestBody Breath breath){

        breathService.updateBreath(breath);
        return "UPDATE: Breath identified by ID "+breath.getId()+" successfully updated.";

    }
}
