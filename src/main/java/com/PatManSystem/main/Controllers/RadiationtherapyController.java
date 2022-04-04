package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.RadiationtherapyDTO;
import com.PatManSystem.main.Services.RadiationtherapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/radiationtherapy" ,
        method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class RadiationtherapyController {

   private final RadiationtherapyService radiationtherapyService;

    @Autowired
    public RadiationtherapyController(RadiationtherapyService radiationtherapyService) {
        this.radiationtherapyService = radiationtherapyService;
    }

    @GetMapping(path = "/all")
    public List<RadiationtherapyDTO> getRadiationtherapy() {return radiationtherapyService.getRadiationtherapys();
    }

    @GetMapping(path ="/id={id}")
    public RadiationtherapyDTO getRadiationtherapy(@PathVariable("id") Integer id){
        return radiationtherapyService.getRadiationtherapy(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<RadiationtherapyDTO> getRadiationtherapys(@PathVariable("ULI") Long ULI){
        return radiationtherapyService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewRadiationtherapy(@RequestBody RadiationtherapyDTO radiationtherapyDTO){

        radiationtherapyService.newRadiationtherapy(radiationtherapyDTO);
        return "NEW: Radiationtherapy identified by ID "+radiationtherapyDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteRadiationtherapy(@PathVariable("id") Integer id){
        radiationtherapyService.deleteRadiationtherapy(id);
        return "DELETE: Radiationtherapy identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateRadiationtherapy(@RequestBody RadiationtherapyDTO radiationtherapyDTO){

        radiationtherapyService.updateRadiationtherapy(radiationtherapyDTO);
        return "UPDATE: Radiationtherapy identified by ID "+radiationtherapyDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateRadiationtherapy(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateRTStart,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateRTEnd,
            @RequestParam(required = false) Integer typeRTId,
            @RequestParam(required = false) Integer locationId,
            @RequestParam(required = false) Double rTDose,
            @RequestParam(required = false) Integer fraction,
            @RequestParam(required = false) Integer planningId,
            @RequestParam(required = false) String anatDetail,
            @RequestParam(required = false) String general,
            @RequestParam(required = false) Integer pneumonitisId,
            @RequestParam(required = false) Integer upperGIId,
            @RequestParam(required = false) Integer skinReactionId,
            @RequestParam(required = false) Integer lowerGIId,
            @RequestParam(required = false) Integer guId,
            @RequestParam(required = false) Integer hemeId,
            @RequestParam(required = false) Integer hepaticId,
            @RequestParam(required = false) String otherToxicity,
            @RequestParam(required = false) String details,
            @RequestParam(required = false) Integer ng
    ){
        radiationtherapyService.updateRadiationtherapy(
                new RadiationtherapyDTO(
                    id,
                    dateRTStart,
                    dateRTEnd,
                    typeRTId,
                    locationId,
                    rTDose,
                    fraction,
                    planningId,
                    anatDetail,
                    general,
                    pneumonitisId,
                    upperGIId,
                    skinReactionId,
                    lowerGIId,
                    guId,
                    hemeId,
                    hepaticId,
                    otherToxicity,
                    details,
                    ng));

        return "UPDATE: Radiationtherapy identified by ID "+id+" successfully updated.";
    }

}
