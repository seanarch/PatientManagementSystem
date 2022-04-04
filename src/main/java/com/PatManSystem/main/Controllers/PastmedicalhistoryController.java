package com.PatManSystem.main.Controllers;


import com.PatManSystem.main.DTO.PastmedicalhistoryDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import java.util.List;
import com.PatManSystem.main.Services.PastmedicalhistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping(path = "/api/pastmedicalhistory" ,
        method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class PastmedicalhistoryController {

    private final PastmedicalhistoryService pastmedicalhistoryService;

    @Autowired
    public PastmedicalhistoryController(PastmedicalhistoryService pastmedicalhistoryService){
        this.pastmedicalhistoryService = pastmedicalhistoryService;
    }

    @GetMapping(path = "/all")
    public List<PastmedicalhistoryDTO> getPastmedicalhistorys(){
        return pastmedicalhistoryService.getPastmedicalhistorys();
    }

    @GetMapping(path = "/id={id}")
    public PastmedicalhistoryDTO getPastmedicalhistoryById(@PathVariable("id") Integer id) throws NotFoundException {
        return pastmedicalhistoryService.getPastmedicalhistoryById(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<PastmedicalhistoryDTO> getPastmedicalhistoryByULI(@PathVariable("ULI") Long ULI) throws NotFoundException {
        return pastmedicalhistoryService.getPastmedicalhistorysByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewPastmedicalhistory(@RequestBody PastmedicalhistoryDTO pastmedicalhistoryDTO) throws DuplicateFoundException {
        pastmedicalhistoryService.newPastmedicalhistory(pastmedicalhistoryDTO);
        return "NEW: Pastmedicalhistory identified by ID " + pastmedicalhistoryDTO.getId() + " successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deletePastmedicalhistory(@PathVariable("id")Integer id) throws NotFoundException {
        pastmedicalhistoryService.deletePastmedicalhistory(id);
        return "DELETE: Pastmedicalhistory identified by ID " + id + " successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updatePastmedicalhistory(@RequestBody PastmedicalhistoryDTO pastmedicalhistoryDTO) throws NotFoundException {
        pastmedicalhistoryService.updatePastmedicalhistory(pastmedicalhistoryDTO);
        return "UPDATE: Pastmedicalhistory identified by ID " + pastmedicalhistoryDTO.getId() + " successfully updated.";
    }

    @PutMapping(path = "update/id={id}")
    public String updatePastmedicalhistory(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) Long uliId,
            @RequestParam(required = false) String dx,
            @RequestParam(required = false) String genDx
    ) throws NotFoundException {
        pastmedicalhistoryService.updatePastmedicalhistory(new PastmedicalhistoryDTO(id, uliId, dx, genDx));
        return "UPDATE: Exam identified by ID "+id+" successfully updated.";
    }

}
