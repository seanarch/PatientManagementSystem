package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Skin;
import com.PatManSystem.main.Services.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/skin" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class SkinController {

    private final SkinService skinService;

    @Autowired
    public SkinController(SkinService skinService) {
        this.skinService = skinService;
    }

    @GetMapping(path = "/all")
    public List<Skin> getSkin() {return skinService.getSkins();
    }

    @GetMapping(path ="/id={id}")
    public Skin getSkin(@PathVariable("id") Integer id){
        return skinService.getSkin(id);
    }

    @PostMapping(path = "/new")
    public String registerNewSkin(@RequestBody Skin skin){
        skinService.newSkin(skin);
        return "NEW: Skin identified by ID "+skin.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteSkin(@PathVariable("id") Integer id){
        skinService.deleteSkin(id);
        return "DELETE: Skin identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateSkin(@RequestBody Skin skin){

        skinService.updateSkin(skin);
        return "UPDATE: Skin identified by ID "+skin.getId()+" successfully updated.";

    }
}