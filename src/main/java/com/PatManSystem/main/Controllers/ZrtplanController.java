package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zrtplan;
import com.PatManSystem.main.Services.ZrtplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zrtplan")
@CrossOrigin("*")
public class ZrtplanController {

    private final ZrtplanService zrtplanService;

    @Autowired
    public ZrtplanController(ZrtplanService zrtplanService) {
        this.zrtplanService = zrtplanService;
    }

    @GetMapping(path = "/all")
    public List<Zrtplan> getZrtplan() {return zrtplanService.getZrtplans();
    }

    @GetMapping(path ="/id={id}")
    public Zrtplan getZrtplan(@PathVariable("id") Integer id){
        return zrtplanService.getZrtplan(id);
    }

    @PostMapping(path = "/new")
    public String registerNewZrtplan(@RequestBody Zrtplan zrtplan){
        zrtplanService.newZrtplan(zrtplan);
        return "NEW: Zrtplan identified by ID "+zrtplan.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZrtplan(@PathVariable("id") Integer id){
        zrtplanService.deleteZrtplan(id);
        return "DELETE: Zrtplan identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZrtplan(@RequestBody Zrtplan zrtplan){

        zrtplanService.updateZrtplan(zrtplan);
        return "UPDATE: Zrtplan identified by ID "+zrtplan.getId()+" successfully updated.";

    }
}
