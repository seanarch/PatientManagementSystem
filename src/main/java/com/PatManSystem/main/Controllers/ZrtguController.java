package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zrtgu;
import com.PatManSystem.main.Services.ZrtguService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zrtgu",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class ZrtguController {

    private final ZrtguService zrtguService;

    @Autowired
    public ZrtguController(ZrtguService zrtguService) {
        this.zrtguService = zrtguService;
    }

    @GetMapping(path = "/all")
    public List<Zrtgu> getZrtgu() {return zrtguService.getZrtgus();
    }

    @GetMapping(path ="/id={id}")
    public Zrtgu getZrtgu(@PathVariable("id") Integer id){
        return zrtguService.getZrtgu(id);
    }

    @PostMapping(path = "/new")
    public String newZrtgu(@RequestBody Zrtgu zrtgu) {
        zrtguService.newZrtgu(zrtgu);
        return "NEW: Zrtgu identified by ID " + zrtgu.getId() + " successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZrtgu(@PathVariable("id") Integer id){
        zrtguService.deleteZrtgu(id);
        return "DELETE: Zrtgu identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZrtgu(@RequestBody Zrtgu zrtgu){

        zrtguService.updateZrtgu(zrtgu);
        return "UPDATE: Zrtgu identified by ID "+zrtgu.getId()+" successfully updated.";

    }
}
