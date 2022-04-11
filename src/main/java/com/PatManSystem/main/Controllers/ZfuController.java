package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Zfu;
import com.PatManSystem.main.Services.ZfuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zfu",
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class ZfuController {

    private final ZfuService zfuService;

    @Autowired
    public ZfuController(ZfuService zfuService) {
        this.zfuService = zfuService;
    }

    @GetMapping(path = "/all")
    public List<Zfu> getZfu() {return zfuService.getZfus();
    }

    @GetMapping(path ="/id={id}")
    public Zfu getZfu(@PathVariable("id") Integer id){
        return zfuService.getZfu(id);
    }

    @PostMapping(path = "/new")
    public String registerNewZfu(@RequestBody Zfu zfu){
        zfuService.newZfu(zfu);
        return "NEW: Zfu identified by ID "+zfu.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteZfu(@PathVariable("id") Integer id){
        zfuService.deleteZfu(id);
        return "DELETE: Zfu identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateZfu(@RequestBody Zfu zfu){

        zfuService.updateZfu(zfu);
        return "UPDATE: Zfu identified by ID "+zfu.getId()+" successfully updated.";

    }
}
