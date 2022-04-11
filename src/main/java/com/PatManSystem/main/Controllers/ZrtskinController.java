package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zrtskin;
import com.PatManSystem.main.Services.ZrtskinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zrtskin",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class ZrtskinController {

    private final ZrtskinService zrtskinService;

    @Autowired
    public ZrtskinController(ZrtskinService zrtskinService) {
        this.zrtskinService = zrtskinService;
    }

    @GetMapping(path = "/all")
    public List<Zrtskin> getZrtskin() {return zrtskinService.getZrtskins();
    }

    @GetMapping(path ="/id={id}")
    public Zrtskin getZrtskin(@PathVariable("id") Integer id){
        return zrtskinService.getZrtskin(id);
    }

    @PostMapping(path = "/new")
    public String registerNewZrtskin(@RequestBody Zrtskin zrtskin){
        zrtskinService.newZrtskin(zrtskin);
        return "NEW: Zrtskin identified by ID "+zrtskin.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZrtskin(@PathVariable("id") Integer id){
        zrtskinService.deleteZrtskin(id);
        return "DELETE: Zrtskin identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZrtskin(@RequestBody Zrtskin zrtskin){

        zrtskinService.updateZrtskin(zrtskin);
        return "UPDATE: Zrtskin identified by ID "+zrtskin.getId()+" successfully updated.";

    }
}