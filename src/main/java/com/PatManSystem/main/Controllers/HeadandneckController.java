package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Headandneck;
import com.PatManSystem.main.Services.HeadandneckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/headandneck" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class HeadandneckController {

    private final HeadandneckService headandneckService;

    @Autowired
    public HeadandneckController(HeadandneckService headandneckService) {
        this.headandneckService = headandneckService;
    }

    @GetMapping(path = "/all")
    public List<Headandneck> getHeadandneck() {return headandneckService.getHeadandnecks();
    }

    @GetMapping(path ="/id={id}")
    public Headandneck getHeadandneck(@PathVariable("id") Integer id){
        return headandneckService.getHeadandneck(id);
    }

    @PostMapping(path = "/new")
    public String registerNewHeadandneck(@RequestBody Headandneck headandneck){
        headandneckService.newHeadandneck(headandneck);
        return "NEW: Headandneck identified by ID "+headandneck.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteHeadandneck(@PathVariable("id") Integer id){
        headandneckService.deleteHeadandneck(id);
        return "DELETE: Headandneck identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateHeadandneck(@RequestBody Headandneck headandneck){

        headandneckService.updateHeadandneck(headandneck);
        return "UPDATE: Headandneck identified by ID "+headandneck.getId()+" successfully updated.";

    }
}
