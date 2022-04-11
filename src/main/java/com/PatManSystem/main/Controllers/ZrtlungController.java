package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zrtlung;
import com.PatManSystem.main.Services.ZrtlungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zrtlung",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class ZrtlungController {

    private final ZrtlungService zrtlungService;

    @Autowired
    public ZrtlungController(ZrtlungService zrtlungService) {
        this.zrtlungService = zrtlungService;
    }

    @GetMapping(path = "/all")
    public List<Zrtlung> getZrtlung() {return zrtlungService.getZrtlungs();
    }

    @GetMapping(path ="/id={id}")
    public Zrtlung getZrtlung(@PathVariable("id") Integer id){
        return zrtlungService.getZrtlung(id);
    }

    @PostMapping(path = "/new")
    public String registerNewZrtlung(@RequestBody Zrtlung zrtlung){
        zrtlungService.newZrtlung(zrtlung);
        return "NEW: Zrtlung identified by ID "+zrtlung.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZrtlung(@PathVariable("id") Integer id){
        zrtlungService.deleteZrtlung(id);
        return "DELETE: Zrtlung identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZrtlung(@RequestBody Zrtlung zrtlung){

        zrtlungService.updateZrtlung(zrtlung);
        return "UPDATE: Zrtlung identified by ID "+zrtlung.getId()+" successfully updated.";

    }
}
