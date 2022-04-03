package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.Models.Typeofdiagnosticimaging;
import com.PatManSystem.main.Services.TypeofdiagnosticimagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeofdiagnosticimaging")
@CrossOrigin("*")
public class TypeofdiagnosticimagingController {

    private final TypeofdiagnosticimagingService typeofdiagnosticimagingService;

    @Autowired
    public TypeofdiagnosticimagingController(TypeofdiagnosticimagingService typeofdiagnosticimagingService) {
        this.typeofdiagnosticimagingService = typeofdiagnosticimagingService;
    }

    @GetMapping(path = "/all")
    public List<Typeofdiagnosticimaging> getTypeofdiagnosticimaging() {return typeofdiagnosticimagingService.getTypeofdiagnosticimagings();
    }

    @GetMapping(path ="/id={id}")
    public Typeofdiagnosticimaging getTypeofdiagnosticimaging(@PathVariable("id") Integer id){
        return typeofdiagnosticimagingService.getTypeofdiagnosticimaging(id);
    }

    @PostMapping(path = "/new")
    public String registerNewTypeofdiagnosticimaging(@RequestBody Typeofdiagnosticimaging typeofdiagnosticimaging){
        typeofdiagnosticimagingService.newTypeofdiagnosticimaging(typeofdiagnosticimaging);
        return "NEW: Typeofdiagnosticimaging identified by ID "+typeofdiagnosticimaging.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteTypeofdiagnosticimaging(@PathVariable("id") Integer id){
        typeofdiagnosticimagingService.deleteTypeofdiagnosticimaging(id);
        return "DELETE: Typeofdiagnosticimaging identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")
    public String updateTypeofdiagnosticimaging(@RequestBody Typeofdiagnosticimaging typeofdiagnosticimaging){

        typeofdiagnosticimagingService.updateTypeofdiagnosticimaging(typeofdiagnosticimaging);
        return "UPDATE: Typeofdiagnosticimaging identified by ID "+typeofdiagnosticimaging.getId()+" successfully updated.";

    }
}
