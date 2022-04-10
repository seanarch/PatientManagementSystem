package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.FollowupDTO;
import com.PatManSystem.main.Services.FollowupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/followup" ,
        method = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST})
@CrossOrigin("*")
public class FollowupController {

    private final FollowupService followupService;

    @Autowired
    public FollowupController(FollowupService followupService) {
        this.followupService = followupService;
    }

    @GetMapping(path = "/all")
    public List<FollowupDTO> getFollowup() {return followupService.getFollowups();
    }

    @GetMapping(path ="/id={id}")
    public FollowupDTO getFollowup(@PathVariable("id") Integer id){
        return followupService.getFollowup(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<FollowupDTO> getFollowups(@PathVariable("ULI") Long ULI){
        return followupService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewFollowup(@RequestBody FollowupDTO followupDTO){

        followupService.newFollowup(followupDTO);
        return "NEW: Followup successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteFollowup(@PathVariable("id") Integer id){
        followupService.deleteFollowup(id);
        return "DELETE: Followup identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateFollowup(@RequestBody FollowupDTO followupDTO){

        followupService.updateFollowup(followupDTO);
        return "UPDATE: Followup identified by ID "+followupDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateFollowup(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) Integer typeFUId,
            @RequestParam(required = false) Integer clinicalResponseId,
            @RequestParam(required = false) Integer pneumonitisId,
            @RequestParam(required = false) Integer upperGIId,
            @RequestParam(required = false) Integer skinReactionId,
            @RequestParam(required = false) Integer lowerGIId,
            @RequestParam(required = false) Integer guId,
            @RequestParam(required = false) Integer hemeId,
            @RequestParam(required = false) Integer hepaticId,
            @RequestParam(required = false) String otherToxicity,
            @RequestParam(required = false) String otherToxDetail
    ){
        followupService.updateFollowup(
                new FollowupDTO(id,date,typeFUId,clinicalResponseId,
                        pneumonitisId,upperGIId,skinReactionId,lowerGIId,
                        guId, hemeId, hepaticId, otherToxicity, otherToxDetail
        ));

        return "UPDATE: Followup identified by ID "+id+" successfully updated.";
    }

}