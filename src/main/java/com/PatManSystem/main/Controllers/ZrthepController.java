package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zrthep;
import com.PatManSystem.main.Services.ZrthepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zrthep" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class ZrthepController {

    private final ZrthepService zrthepService;

    @Autowired
    public ZrthepController(ZrthepService zrthepService) {
        this.zrthepService = zrthepService;
    }

    @GetMapping(path = "/all")
    public List<Zrthep> getZrthep() {return zrthepService.getZrtheps();
    }

    @GetMapping(path ="/id={id}")
    public Zrthep getZrthep(@PathVariable("id") Integer id){
        return zrthepService.getZrthep(id);
    }

    @PostMapping(path = "/new")
    public String registerNewZrthep(@RequestBody Zrthep zrthep){
        zrthepService.newZrthep(zrthep);
        return "NEW: Zrthep identified by ID "+zrthep.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZrthep(@PathVariable("id") Integer id){
        zrthepService.deleteZrthep(id);
        return "DELETE: Zrthep identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZrthep(@RequestBody Zrthep zrthep){

        zrthepService.updateZrthep(zrthep);
        return "UPDATE: Zrthep identified by ID "+zrthep.getId()+" successfully updated.";

    }
}
