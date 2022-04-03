package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zrtugi;
import com.PatManSystem.main.Services.ZrtugiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zrtugi")
@CrossOrigin("*")
public class ZrtugiController {

    private final ZrtugiService zrtugiService;

    @Autowired
    public ZrtugiController(ZrtugiService zrtugiService) {
        this.zrtugiService = zrtugiService;
    }

    @GetMapping(path = "/all")
    public List<Zrtugi> getZrtugi() {return zrtugiService.getZrtugis();
    }

    @GetMapping(path ="/id={id}")
    public Zrtugi getZrtugi(@PathVariable("id") Integer id){
        return zrtugiService.getZrtugi(id);
    }

    @PostMapping(path = "/new")
    public String registerNewZrtugi(@RequestBody Zrtugi zrtugi){
        zrtugiService.newZrtugi(zrtugi);
        return "NEW: Zrtugi identified by ID "+zrtugi.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZrtugi(@PathVariable("id") Integer id){
        zrtugiService.deleteZrtugi(id);
        return "DELETE: Zrtugi identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZrtugi(@RequestBody Zrtugi zrtugi){

        zrtugiService.updateZrtugi(zrtugi);
        return "UPDATE: Zrtugi identified by ID "+zrtugi.getId()+" successfully updated.";

    }
}
