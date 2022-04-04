package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zrtlgi;
import com.PatManSystem.main.Services.ZrtlgiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zrtlgi" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class ZrtlgiController {

    private final ZrtlgiService zrtlgiService;

    @Autowired
    public ZrtlgiController(ZrtlgiService zrtlgiService) {
        this.zrtlgiService = zrtlgiService;
    }

    @GetMapping(path = "/all")
    public List<Zrtlgi> getZrtlgi() {return zrtlgiService.getZrtlgis();
    }

    @GetMapping(path ="/id={id}")
    public Zrtlgi getZrtlgi(@PathVariable("id") Integer id){
        return zrtlgiService.getZrtlgi(id);
    }

    @PostMapping(path = "/new")
    public String registerNewZrtlgi(@RequestBody Zrtlgi zrtlgi){
        zrtlgiService.newZrtlgi(zrtlgi);
        return "NEW: Zrtlgi identified by ID "+zrtlgi.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZrtlgi(@PathVariable("id") Integer id){
        zrtlgiService.deleteZrtlgi(id);
        return "DELETE: Zrtlgi identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZrtlgi(@RequestBody Zrtlgi zrtlgi){

        zrtlgiService.updateZrtlgi(zrtlgi);
        return "UPDATE: Zrtlgi identified by ID "+zrtlgi.getId()+" successfully updated.";

    }
}