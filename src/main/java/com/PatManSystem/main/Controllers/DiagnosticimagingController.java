package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.DiagnosticimagingDTO;
import com.PatManSystem.main.Services.DiagnosticimagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/diagnosticimaging")
@CrossOrigin("*")
public class DiagnosticimagingController {
    private final DiagnosticimagingService diagnosticimagingService;

    @Autowired
    public DiagnosticimagingController(DiagnosticimagingService diagnosticimagingService) {
        this.diagnosticimagingService = diagnosticimagingService;
    }

    @GetMapping(path = "/all")
    public List<DiagnosticimagingDTO> getDiagnosticimaging() {return diagnosticimagingService.getDiagnosticimagings();
    }

    @GetMapping(path ="/id={id}")
    public DiagnosticimagingDTO getDiagnosticimaging(@PathVariable("id") Integer id){
        return diagnosticimagingService.getDiagnosticimaging(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<DiagnosticimagingDTO> getDiagnosticimagings(@PathVariable("ULI") Long ULI){
        return diagnosticimagingService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewDiagnosticimaging(@RequestBody DiagnosticimagingDTO diagnosticimagingDTO){

        diagnosticimagingService.newDiagnosticimaging(diagnosticimagingDTO);
        return "NEW: Diagnosticimaging identified by ID "+diagnosticimagingDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteDiagnosticimaging(@PathVariable("id") Integer id){
        diagnosticimagingService.deleteDiagnosticimaging(id);
        return "DELETE: Diagnosticimaging identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateDiagnosticimaging(@RequestBody DiagnosticimagingDTO diagnosticimagingDTO){

        diagnosticimagingService.updateDiagnosticimaging(diagnosticimagingDTO);
        return "UPDATE: Diagnosticimaging identified by ID "+diagnosticimagingDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateDiagnosticimaging(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDI,
            @RequestParam(required = false) Integer typeDIId,
            @RequestParam(required = false) String finding
    ){
        diagnosticimagingService.updateDiagnosticimaging(new DiagnosticimagingDTO(id,dateDI,typeDIId,finding));

        return "UPDATE: Diagnosticimaging identified by ID "+id+" successfully updated.";
    }
}
