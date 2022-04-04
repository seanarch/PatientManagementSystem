package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Musculoskeletal;
import com.PatManSystem.main.Services.MusculoskeletalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/musculoskeletal" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class MusculoskeletalController {

    private final MusculoskeletalService musculoskeletalService;

    @Autowired
    public MusculoskeletalController(MusculoskeletalService musculoskeletalService) {
        this.musculoskeletalService = musculoskeletalService;
    }

    @GetMapping(path = "/all")
    public List<Musculoskeletal> getMusculoskeletal() {return musculoskeletalService.getMusculoskeletals();
    }

    @GetMapping(path ="/id={id}")
    public Musculoskeletal getMusculoskeletal(@PathVariable("id") Integer id){
        return musculoskeletalService.getMusculoskeletal(id);
    }

    @PostMapping(path = "/new")
    public String registerNewMusculoskeletal(@RequestBody Musculoskeletal musculoskeletal){
        musculoskeletalService.newMusculoskeletal(musculoskeletal);
        return "NEW: Musculoskeletal identified by ID "+musculoskeletal.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteMusculoskeletal(@PathVariable("id") Integer id){
        musculoskeletalService.deleteMusculoskeletal(id);
        return "DELETE: Musculoskeletal identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateMusculoskeletal(@RequestBody Musculoskeletal musculoskeletal){

        musculoskeletalService.updateMusculoskeletal(musculoskeletal);
        return "UPDATE: Musculoskeletal identified by ID "+musculoskeletal.getId()+" successfully updated.";

    }
}