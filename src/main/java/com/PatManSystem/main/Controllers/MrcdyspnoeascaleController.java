package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Mrcdyspnoeascale;
import com.PatManSystem.main.Services.MrcdyspnoeascaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/mrcdyspnoeascale")
@CrossOrigin("*")
public class MrcdyspnoeascaleController {

    private final MrcdyspnoeascaleService mrcdyspnoeascaleService;

    @Autowired
    public MrcdyspnoeascaleController(MrcdyspnoeascaleService mrcdyspnoeascaleService) {
        this.mrcdyspnoeascaleService = mrcdyspnoeascaleService;
    }

    @GetMapping(path = "/all")
    public List<Mrcdyspnoeascale> getMrcdyspnoeascale() {return mrcdyspnoeascaleService.getMrcdyspnoeascales();
    }

    @GetMapping(path ="/id={id}")
    public Mrcdyspnoeascale getMrcdyspnoeascale(@PathVariable("id") Integer id){
        return mrcdyspnoeascaleService.getMrcdyspnoeascale(id);
    }

    @PostMapping(path = "/new")
    public String registerNewMrcdyspnoeascale(@RequestBody Mrcdyspnoeascale mrcdyspnoeascale){
        mrcdyspnoeascaleService.newMrcdyspnoeascale(mrcdyspnoeascale);
        return "NEW: Mrcdyspnoeascale identified by ID "+mrcdyspnoeascale.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteMrcdyspnoeascale(@PathVariable("id") Integer id){
        mrcdyspnoeascaleService.deleteMrcdyspnoeascale(id);
        return "DELETE: Mrcdyspnoeascale identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateMrcdyspnoeascale(@RequestBody Mrcdyspnoeascale mrcdyspnoeascale){

        mrcdyspnoeascaleService.updateMrcdyspnoeascale(mrcdyspnoeascale);
        return "UPDATE: Mrcdyspnoeascale identified by ID "+mrcdyspnoeascale.getId()+" successfully updated.";

    }
}
