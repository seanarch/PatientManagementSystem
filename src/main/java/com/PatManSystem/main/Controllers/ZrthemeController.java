package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zrtheme;
import com.PatManSystem.main.Services.ZrthemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zrtheme",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class ZrthemeController {

    private final ZrthemeService zrthemeService;

    @Autowired
    public ZrthemeController(ZrthemeService zrthemeService) {
        this.zrthemeService = zrthemeService;
    }

    @GetMapping(path = "/all")
    public List<Zrtheme> getZrtheme() {return zrthemeService.getZrthemes();
    }

    @GetMapping(path ="/id={id}")
    public Zrtheme getZrtheme(@PathVariable("id") Integer id){
        return zrthemeService.getZrtheme(id);
    }

    @PostMapping(path = "/new")
    public String registerNewZrtheme(@RequestBody Zrtheme zrtheme){
        zrthemeService.newZrtheme(zrtheme);
        return "NEW: Zrtheme identified by ID "+zrtheme.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZrtheme(@PathVariable("id") Integer id){
        zrthemeService.deleteZrtheme(id);
        return "DELETE: Zrtheme identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZrtheme(@RequestBody Zrtheme zrtheme){

        zrthemeService.updateZrtheme(zrtheme);
        return "UPDATE: Zrtheme identified by ID "+zrtheme.getId()+" successfully updated.";

    }
}
