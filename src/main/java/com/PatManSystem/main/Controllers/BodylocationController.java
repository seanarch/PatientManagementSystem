package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Bodylocation;
import com.PatManSystem.main.Services.BodylocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/bodylocation" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class BodylocationController {

    private final BodylocationService bodylocationService;

    @Autowired
    public BodylocationController(BodylocationService bodylocationService) {
        this.bodylocationService = bodylocationService;
    }

    @GetMapping(path = "/all")
    public List<Bodylocation> getBodylocation() {return bodylocationService.getBodylocations();
    }

    @GetMapping(path ="/id={id}")
    public Bodylocation getBodylocation(@PathVariable("id") Integer id){
        return bodylocationService.getBodylocation(id);
    }

    @PostMapping(path = "/new")
    public String registerNewBodylocation(@RequestBody Bodylocation bodylocation){
        bodylocationService.newBodylocation(bodylocation);
        return "NEW: Bodylocation identified by ID "+bodylocation.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteBodylocation(@PathVariable("id") Integer id){
        bodylocationService.deleteBodylocation(id);
        return "DELETE: Bodylocation identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateBodylocation(@RequestBody Bodylocation bodylocation){

        bodylocationService.updateBodylocation(bodylocation);
        return "UPDATE: Bodylocation identified by ID "+bodylocation.getId()+" successfully updated.";

    }
}
