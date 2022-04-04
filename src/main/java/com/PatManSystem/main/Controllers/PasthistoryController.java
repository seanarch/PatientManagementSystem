package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.PasthistoryDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Services.PasthistoryService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/pasthistory" ,
        method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class PasthistoryController {
    private final PasthistoryService pasthistoryService;

    @Autowired
    public PasthistoryController(PasthistoryService pasthistoryService){
        this.pasthistoryService = pasthistoryService;
    }

    @GetMapping(path ="/id={id}")
    public PasthistoryDTO getPasthistory(@PathVariable("id") Integer id) throws NotFoundException {
        return pasthistoryService.getPasthistory(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<PasthistoryDTO> getPasthistorys(@PathVariable("ULI") Long ULI) throws NotFoundException {
        return pasthistoryService.getPasthistoryByULI(ULI);
    }

    @GetMapping(path = "/all")
    public  List<PasthistoryDTO> getPasthistorys(){
        return pasthistoryService.getPasthistorys();
    }

    @PostMapping(path = "/new")
    public String registerPasthistory(@RequestBody PasthistoryDTO pasthistoryDTO) throws DuplicateFoundException {
        pasthistoryService.newPasthistory(pasthistoryDTO);
        return "NEW: Pasthistory identified by ID "+ pasthistoryDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deletePasthistory(@PathVariable("id") Integer id) throws NotFoundException {
        pasthistoryService.deletePasthistory(id);
        return "DELETE: Pasthistory identified by ID "+ id +" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updatePasthistory(@RequestBody PasthistoryDTO pasthistoryDTO) throws NotFoundException {

        pasthistoryService.updatePasthistory(pasthistoryDTO);
        return "UPDATE: Pasthistory identified by ULI "+ pasthistoryDTO.getUliId() +" successfully updated.";
    }

    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updatePasthistory(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String fhxDetail,
            @RequestParam(required = false) Integer smokingPackYears,
            @RequestParam(required = false) String smokingQuit,
            @RequestParam(required = false) Integer attendedFamily,
            @RequestParam(required = false) Integer lacksSocialSupport,
            @RequestParam(required = false) Integer languageBarrier,
            @RequestParam(required = false) Integer financialChallenge,
            @RequestParam(required = false) Integer psychosocialChallenge,
            @RequestParam(required = false) Integer goalofcareId,
            @RequestParam(required = false) String detail,
            @RequestParam(required = false) String eTOHWeek
    ) throws NotFoundException {
        pasthistoryService.updatePasthistory(new PasthistoryDTO(id,fhxDetail,smokingPackYears,smokingQuit,attendedFamily,lacksSocialSupport,languageBarrier
        ,financialChallenge,psychosocialChallenge,goalofcareId,detail,eTOHWeek));

        return "UPDATE: Management identified by ID "+id+" successfully updated.";
    }
}

