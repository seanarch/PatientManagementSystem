package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Mellowscore;
import com.PatManSystem.main.Services.MellowscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/mellowscore" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class MellowscoreController {

    private final MellowscoreService mellowscoreService;

    @Autowired
    public MellowscoreController(MellowscoreService mellowscoreService) {
        this.mellowscoreService = mellowscoreService;
    }

    @GetMapping(path = "/all")
    public List<Mellowscore> getMellowscore() {return mellowscoreService.getMellowscores();
    }

    @GetMapping(path ="/id={id}")
    public Mellowscore getMellowscore(@PathVariable("id") Integer id){
        return mellowscoreService.getMellowscore(id);
    }

    @PostMapping(path = "/new")
    public String registerNewMellowscore(@RequestBody Mellowscore mellowscore){
        mellowscoreService.newMellowscore(mellowscore);
        return "NEW: Mellowscore identified by ID "+mellowscore.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteMellowscore(@PathVariable("id") Integer id){
        mellowscoreService.deleteMellowscore(id);
        return "DELETE: Mellowscore identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateMellowscore(@RequestBody Mellowscore mellowscore){

        mellowscoreService.updateMellowscore(mellowscore);
        return "UPDATE: Mellowscore identified by ID "+mellowscore.getId()+" successfully updated.";

    }
}