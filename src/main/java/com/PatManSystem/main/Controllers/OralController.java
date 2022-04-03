package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Oral;
import com.PatManSystem.main.Services.OralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/oral")
@CrossOrigin("*")
public class OralController {

    private final OralService oralService;

    @Autowired
    public OralController(OralService oralService) {
        this.oralService = oralService;
    }

    @GetMapping(path = "/all")
    public List<Oral> getOral() {return oralService.getOrals();
    }

    @GetMapping(path ="/id={id}")
    public Oral getOral(@PathVariable("id") Integer id){
        return oralService.getOral(id);
    }

    @PostMapping(path = "/new")
    public String registerNewOral(@RequestBody Oral oral){
        oralService.newOral(oral);
        return "NEW: Oral identified by ID "+oral.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteOral(@PathVariable("id") Integer id){
        oralService.deleteOral(id);
        return "DELETE: Oral identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateOral(@RequestBody Oral oral){

        oralService.updateOral(oral);
        return "UPDATE: Oral identified by ID "+oral.getId()+" successfully updated.";

    }
}
