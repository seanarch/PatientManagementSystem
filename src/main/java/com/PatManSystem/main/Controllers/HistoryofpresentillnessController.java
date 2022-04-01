package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.HistoryofpresentillnessDTO;
import com.PatManSystem.main.Services.HistoryofpresentillnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/historyofpresentillness")
@CrossOrigin("*")
public class HistoryofpresentillnessController {

    private final HistoryofpresentillnessService historyofpresentillnessService;

    @Autowired
    public HistoryofpresentillnessController(HistoryofpresentillnessService historyofpresentillnessService) {
        this.historyofpresentillnessService = historyofpresentillnessService;
    }

    @GetMapping(path = "/all")
    public List<HistoryofpresentillnessDTO> getHistoryofpresentillness() {return historyofpresentillnessService.getHistoryofpresentillnesss();
    }

    @GetMapping(path ="/id={id}")
    public HistoryofpresentillnessDTO getHistoryofpresentillness(@PathVariable("id") Integer id){
        return historyofpresentillnessService.getHistoryofpresentillness(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<HistoryofpresentillnessDTO> getHistoryofpresentillnesss(@PathVariable("ULI") Long ULI){
        return historyofpresentillnessService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewHistoryofpresentillness(@RequestBody HistoryofpresentillnessDTO historyofpresentillnessDTO){

        historyofpresentillnessService.newHistoryofpresentillness(historyofpresentillnessDTO);
        return "NEW: Historyofpresentillness identified by ID "+historyofpresentillnessDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteHistoryofpresentillness(@PathVariable("id") Integer id){
        historyofpresentillnessService.deleteHistoryofpresentillness(id);
        return "DELETE: Historyofpresentillness identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateHistoryofpresentillness(@RequestBody HistoryofpresentillnessDTO historyofpresentillnessDTO){

        historyofpresentillnessService.updateHistoryofpresentillness(historyofpresentillnessDTO);
        return "UPDATE: Historyofpresentillness identified by ID "+historyofpresentillnessDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateHistoryofpresentillness(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) Integer decriptorId
    ){
        historyofpresentillnessService.updateHistoryofpresentillness(new HistoryofpresentillnessDTO(id,decriptorId));

        return "UPDATE: Historyofpresentillness identified by ID "+id+" successfully updated.";
    }

}
