package com.PatManSystem.main.Controllers;


import com.PatManSystem.main.DTO.NewpatientconsultDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Services.NewpatientconsultService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping(path = "/api/newpatientconsult")
@CrossOrigin("*")

public class NewpatientconsultController {

    private final NewpatientconsultService newpatientconsultService;

    @Autowired
    public NewpatientconsultController(NewpatientconsultService newpatientconsultService) { this.newpatientconsultService = newpatientconsultService;}

    @GetMapping(path ="/all")
    public List<NewpatientconsultDTO> getNewpatientconsults(){
        return newpatientconsultService.getNewpatientconsults();
    }

    @GetMapping(path ="/id={id}")
    public NewpatientconsultDTO getNewpatientconsult(@PathVariable("id") Integer id) throws NotFoundException {
        return newpatientconsultService.getNewpatientconsult(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<NewpatientconsultDTO> getNewpatientconsults(@PathVariable("ULI") Long ULI) throws NotFoundException {
        return newpatientconsultService.getNewpatientconsultByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewpatientconsult(@RequestBody NewpatientconsultDTO newpatientconsultDTO) throws DuplicateFoundException {
        newpatientconsultService.newNewpatientconsult(newpatientconsultDTO);
        return "NEW: Newpatientconsult identified by ID "+newpatientconsultDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteNewpatientconsult(@PathVariable("id") Integer id) throws NotFoundException {
        newpatientconsultService.deleteNewpatientconsult(id);
        return "DELETE: Newpatientconsult identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateNewpatientconsult(@RequestBody NewpatientconsultDTO newpatientconsultDTO) throws NotFoundException {

        newpatientconsultService.updateNewpatientconsult(newpatientconsultDTO);
        return "UPDATE: Newpatientconsult identified by ULI "+ newpatientconsultDTO.getUliId() +" successfully updated.";
    }

    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateNewpatientconsult(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) Long uliId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date // date parsed from JSON is STRING, addition formatting required to convert to LocalDate Obj
    ) throws NotFoundException {
        newpatientconsultService.updateNewpatientconsult(new NewpatientconsultDTO(id,uliId,date));

        return "UPDATE: Newpatientconsult identified by ID "+id+" successfully updated.";
    }
}
