package com.PatManSystem.main.Controllers;


import com.PatManSystem.main.DTO.ManagementDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Services.ManagementService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/management" ,
        method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class ManagementController {
    private final ManagementService managementService;

    @Autowired
    public ManagementController(ManagementService managementService){this.managementService = managementService;}

    @GetMapping(path ="/all")
    public List<ManagementDTO> getManagements(){
        return managementService.getManagements();
    }

    @GetMapping(path ="/id={id}")
    public ManagementDTO getManagement(@PathVariable("id") Integer id) throws NotFoundException {
        return managementService.getManagement(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<ManagementDTO> getManagements(@PathVariable("ULI") Long ULI) throws NotFoundException {
        return managementService.getManagementByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewManagement(@RequestBody ManagementDTO managementDTO) throws DuplicateFoundException {
        managementService.newManagement(managementDTO);
        return "NEW: Management successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteManagement(@PathVariable("id") Integer id) throws NotFoundException {
        managementService.deleteManagement(id);
        return "DELETE: Management identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateManagement(@RequestBody ManagementDTO managementDTO) throws NotFoundException {

        managementService.updateManagement(managementDTO);
        return "UPDATE: Management identified by ULI "+ managementDTO.getUliId() +" successfully updated.";
    }

    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateManagement(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, // date parsed from JSON is STRING, addition formatting required to convert to LocalDate Obj
            @RequestParam(required = false) Integer interventionId,
            @RequestParam(required = false) String detail

    ) throws NotFoundException {
        managementService.updateManagement(new ManagementDTO(id,date,interventionId,detail));

        return "UPDATE: Management identified by ID "+id+" successfully updated.";
    }
}

