package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.PulmonaryfunctiontestDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

import com.PatManSystem.main.Services.PulmonaryfunctiontestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/pulmonaryfunctiontest" ,
        method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class PulmonaryfunctiontestController {
    private final PulmonaryfunctiontestService pulmonaryfunctiontestService;

    @Autowired
    public PulmonaryfunctiontestController(PulmonaryfunctiontestService pulmonaryfunctiontestService){
        this.pulmonaryfunctiontestService = pulmonaryfunctiontestService;
    }

    @GetMapping(path = "/all")
    public List<PulmonaryfunctiontestDTO> getPulmonaryfunctiontests(){
        return pulmonaryfunctiontestService.getPulmonaryfunctiontests();
    }

    @GetMapping(path = "/id={id}")
    public PulmonaryfunctiontestDTO getPulmonaryfunctiontestById(@PathVariable("id") Integer id) throws NotFoundException {
        return pulmonaryfunctiontestService.getPulmonaryfunctiontestById(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<PulmonaryfunctiontestDTO> getPulmonaryfunctiontestByULI(@PathVariable("ULI") Long ULI) throws NotFoundException {
        return pulmonaryfunctiontestService.getPulmonaryfunctiontestByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewPulmonaryfunctiontest(@RequestBody PulmonaryfunctiontestDTO pulmonaryfunctiontestDTO) throws DuplicateFoundException {
        pulmonaryfunctiontestService.newPulmonaryfunctiontest(pulmonaryfunctiontestDTO);
        return "NEW: Pulmonaryfunctiontest identified by ID " + pulmonaryfunctiontestDTO.getId() + " successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deletePulmonaryfunctiontest(@PathVariable("id")Integer id) throws NotFoundException {
            pulmonaryfunctiontestService.deletePulmonaryfunctiontest(id);
        return "DELETE: Pulmonaryfunctiontest identified by ID " + id + " successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updatePulmonaryfunctiontest(@RequestBody PulmonaryfunctiontestDTO pulmonaryfunctiontestDTO) throws NotFoundException {
        pulmonaryfunctiontestService.updatePulmonaryfunctiontest(pulmonaryfunctiontestDTO);
        return "UPDATE: Pulmonaryfunctiontest identified by ID " + pulmonaryfunctiontestDTO.getId() + " successfully updated.";
    }

    @PutMapping(path = "/update/id={id}")
    public String updatePulmonaryfunctiontest(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) Long uliId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, // date parsed from JSON is STRING, addition formatting required to convert to LocalDate Obj
            @RequestParam(required = false) Double fvc,
            @RequestParam(required = false) Integer fvc1,
            @RequestParam(required = false) Double fev1,
            @RequestParam(required = false) Integer fev11,
            @RequestParam(required = false) Integer ratio,
            @RequestParam(required = false) Integer dlco
    ) throws NotFoundException {
        pulmonaryfunctiontestService.updatePulmonaryfunctiontest(
                new PulmonaryfunctiontestDTO(id,uliId,date,fvc,fvc1,fev1,fev11,ratio,dlco));
        return "UPDATE: Pulmonaryfunctiontest identified by ID " + id + " successfully updated.";
    }
}
