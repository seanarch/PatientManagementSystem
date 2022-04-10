package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Cardiac;
import com.PatManSystem.main.Services.CardiacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cardiac" ,
        method = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class CardiacController {

    private final CardiacService cardiacService;

    @Autowired
    public CardiacController(CardiacService cardiacService) {
        this.cardiacService = cardiacService;
    }

    @GetMapping(path = "/all")
    public List<Cardiac> getCardiac() {return cardiacService.getCardiacs();
    }

    @GetMapping(path ="/id={id}")
    public Cardiac getCardiac(@PathVariable("id") Integer id){
        return cardiacService.getCardiac(id);
    }

    @PostMapping(path = "/new")
    public String registerNewCardiac(@RequestBody Cardiac cardiac){
        cardiacService.newCardiac(cardiac);
        return "NEW: Cardiac identified by ID "+cardiac.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteCardiac(@PathVariable("id") Integer id){
        cardiacService.deleteCardiac(id);
        return "DELETE: Cardiac identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateCardiac(@RequestBody Cardiac cardiac){

        cardiacService.updateCardiac(cardiac);
        return "UPDATE: Cardiac identified by ID "+cardiac.getId()+" successfully updated.";

    }
}