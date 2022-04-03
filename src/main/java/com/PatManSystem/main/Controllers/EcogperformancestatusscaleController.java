package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Ecogperformancestatusscale;
import com.PatManSystem.main.Services.EcogperformancestatusscaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/ecogperformancestatusscale")
@CrossOrigin("*")
public class EcogperformancestatusscaleController {

    private final EcogperformancestatusscaleService ecogperformancestatusscaleService;

    @Autowired
    public EcogperformancestatusscaleController(EcogperformancestatusscaleService ecogperformancestatusscaleService) {
        this.ecogperformancestatusscaleService = ecogperformancestatusscaleService;
    }

    @GetMapping(path = "/all")
    public List<Ecogperformancestatusscale> getEcogperformancestatusscale() {return ecogperformancestatusscaleService.getEcogperformancestatusscales();
    }

    @GetMapping(path ="/id={id}")
    public Ecogperformancestatusscale getEcogperformancestatusscale(@PathVariable("id") Integer id){
        return ecogperformancestatusscaleService.getEcogperformancestatusscale(id);
    }

    @PostMapping(path = "/new")
    public String registerNewEcogperformancestatusscale(@RequestBody Ecogperformancestatusscale ecogperformancestatusscale){
        ecogperformancestatusscaleService.newEcogperformancestatusscale(ecogperformancestatusscale);
        return "NEW: Ecogperformancestatusscale identified by ID "+ecogperformancestatusscale.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteEcogperformancestatusscale(@PathVariable("id") Integer id){
        ecogperformancestatusscaleService.deleteEcogperformancestatusscale(id);
        return "DELETE: Ecogperformancestatusscale identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateEcogperformancestatusscale(@RequestBody Ecogperformancestatusscale ecogperformancestatusscale){

        ecogperformancestatusscaleService.updateEcogperformancestatusscale(ecogperformancestatusscale);
        return "UPDATE: Ecogperformancestatusscale identified by ID "+ecogperformancestatusscale.getId()+" successfully updated.";

    }
}
