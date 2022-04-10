package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Abdomen;
import com.PatManSystem.main.Services.AbdomenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/api/abdomen",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class AbdomenController {

    private final AbdomenService abdomenService;

    @Autowired
    public AbdomenController(AbdomenService abdomenService) {
        this.abdomenService = abdomenService;
    }

    @GetMapping(path = "/all")
    public List<Abdomen> getAbdomen() {return abdomenService.getAbdomens();
    }

    @GetMapping(path ="/id={id}")
    public Abdomen getAbdomen(@PathVariable("id") Integer id){
        return abdomenService.getAbdomen(id);
    }

    @PostMapping(path = "/new")
    public String registerNewAbdomen(@RequestBody Abdomen abdomen){
        abdomenService.newAbdomen(abdomen);
        return "NEW: Abdomen identified by ID "+abdomen.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteAbdomen(@PathVariable("id") Integer id){
        abdomenService.deleteAbdomen(id);
        return "DELETE: Abdomen identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateAbdomen(@RequestBody Abdomen abdomen){

        abdomenService.updateAbdomen(abdomen);
        return "UPDATE: Abdomen identified by ID "+abdomen.getId()+" successfully updated.";

    }
}