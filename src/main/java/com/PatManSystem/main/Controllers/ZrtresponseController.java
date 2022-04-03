package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zrtresponse;
import com.PatManSystem.main.Services.ZrtresponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zrtresponse")
@CrossOrigin("*")
public class ZrtresponseController {

    private final ZrtresponseService zrtresponseService;

    @Autowired
    public ZrtresponseController(ZrtresponseService zrtresponseService) {
        this.zrtresponseService = zrtresponseService;
    }

    @GetMapping(path = "/all")
    public List<Zrtresponse> getZrtresponse() {return zrtresponseService.getZrtresponses();
    }

    @GetMapping(path ="/id={id}")
    public Zrtresponse getZrtresponse(@PathVariable("id") Integer id){
        return zrtresponseService.getZrtresponse(id);
    }

    @PostMapping(path = "/new")
    public String registerNewZrtresponse(@RequestBody Zrtresponse zrtresponse){
        zrtresponseService.newZrtresponse(zrtresponse);
        return "NEW: Zrtresponse identified by ID "+zrtresponse.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZrtresponse(@PathVariable("id") Integer id){
        zrtresponseService.deleteZrtresponse(id);
        return "DELETE: Zrtresponse identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZrtresponse(@RequestBody Zrtresponse zrtresponse){

        zrtresponseService.updateZrtresponse(zrtresponse);
        return "UPDATE: Zrtresponse identified by ID "+zrtresponse.getId()+" successfully updated.";

    }
}
