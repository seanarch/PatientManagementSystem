package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Goalofcare;
import com.PatManSystem.main.Services.GoalofcareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/goalofcare")
@CrossOrigin("*")
public class GoalofcareController {

    private final GoalofcareService goalofcareService;

    @Autowired
    public GoalofcareController(GoalofcareService goalofcareService) {
        this.goalofcareService = goalofcareService;
    }

    @GetMapping(path = "/all")
    public List<Goalofcare> getGoalofcare() {return goalofcareService.getGoalofcares();
    }

    @GetMapping(path ="/id={id}")
    public Goalofcare getGoalofcare(@PathVariable("id") Integer id){
        return goalofcareService.getGoalofcare(id);
    }

    @PostMapping(path = "/new")
    public String registerNewGoalofcare(@RequestBody Goalofcare goalofcare){
        goalofcareService.newGoalofcare(goalofcare);
        return "NEW: Goalofcare identified by ID "+goalofcare.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteGoalofcare(@PathVariable("id") Integer id){
        goalofcareService.deleteGoalofcare(id);
        return "DELETE: Goalofcare identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateGoalofcare(@RequestBody Goalofcare goalofcare){

        goalofcareService.updateGoalofcare(goalofcare);
        return "UPDATE: Goalofcare identified by ID "+goalofcare.getId()+" successfully updated.";

    }
}