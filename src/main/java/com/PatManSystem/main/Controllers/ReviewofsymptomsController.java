package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.ReviewofsymptomsDTO;
import com.PatManSystem.main.Services.ReviewofsymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/reviewofsymptoms")
@CrossOrigin("*")
public class ReviewofsymptomsController {

    private final ReviewofsymptomsService reviewofsymptomsService;

    @Autowired
    public ReviewofsymptomsController(ReviewofsymptomsService reviewofsymptomsService) {
        this.reviewofsymptomsService = reviewofsymptomsService;
    }

    @GetMapping(path = "/all")
    public List<ReviewofsymptomsDTO> getReviewofsymptoms() {return reviewofsymptomsService.getReviewofsymptomss();
    }

    @GetMapping(path ="/id={id}")
    public ReviewofsymptomsDTO getReviewofsymptoms(@PathVariable("id") Integer id){
        return reviewofsymptomsService.getReviewofsymptoms(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<ReviewofsymptomsDTO> getReviewofsymptomss(@PathVariable("ULI") Long ULI){
        return reviewofsymptomsService.getByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewReviewofsymptoms(@RequestBody ReviewofsymptomsDTO reviewofsymptomsDTO){

        reviewofsymptomsService.newReviewofsymptoms(reviewofsymptomsDTO);
        return "NEW: Reviewofsymptoms identified by ID "+reviewofsymptomsDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteReviewofsymptoms(@PathVariable("id") Integer id){
        reviewofsymptomsService.deleteReviewofsymptoms(id);
        return "DELETE: Reviewofsymptoms identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateReviewofsymptoms(@RequestBody ReviewofsymptomsDTO reviewofsymptomsDTO){

        reviewofsymptomsService.updateReviewofsymptoms(reviewofsymptomsDTO);
        return "UPDATE: Reviewofsymptoms identified by ID "+reviewofsymptomsDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateReviewofsymptoms(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,           
            @RequestParam(required = false) Integer feversChills,
            @RequestParam(required = false) Integer bADLs,
            @RequestParam(required = false) Integer iADLs,
            @RequestParam(required = false) Integer appetiteLoss,
            @RequestParam(required = false) Integer difficultyChewing,
            @RequestParam(required = false) Integer abdominalPain,
            @RequestParam(required = false) Integer nauseaVomiting,
            @RequestParam(required = false) Integer heartburn,
            @RequestParam(required = false) Integer constipation,
            @RequestParam(required = false) Integer hemetemesis,
            @RequestParam(required = false) Integer melena,
            @RequestParam(required = false) Integer rectalBleed,
            @RequestParam(required = false) Integer nocturea,
            @RequestParam(required = false) Integer hesitancy,
            @RequestParam(required = false) Integer hematurea,
            @RequestParam(required = false) Integer pneumaturea,
            @RequestParam(required = false) Integer backBoneJointPain,
            @RequestParam(required = false) Integer sob,
            @RequestParam(required = false) Integer cough,
            @RequestParam(required = false) Integer hemoptisis,
            @RequestParam(required = false) Integer wheeze,
            @RequestParam(required = false) Integer chestPain,
            @RequestParam(required = false) Integer headaches,
            @RequestParam(required = false) Integer visionChanges,
            @RequestParam(required = false) Integer hearing,
            @RequestParam(required = false) Integer speechChanges,
            @RequestParam(required = false) Integer focalWeakness,
            @RequestParam(required = false) Integer ed
    ){
        reviewofsymptomsService.updateReviewofsymptoms(
                new ReviewofsymptomsDTO(
                        id,
                        date,
                        feversChills,
                        bADLs,
                        iADLs,
                        appetiteLoss,
                        difficultyChewing,
                        abdominalPain,
                        nauseaVomiting,
                        heartburn,
                        constipation,
                        hemetemesis,
                        melena,
                        rectalBleed,
                        nocturea,
                        hesitancy,
                        hematurea,
                        pneumaturea,
                        backBoneJointPain,
                        sob,
                        cough,
                        hemoptisis,
                        wheeze,
                        chestPain,
                        headaches,
                        visionChanges,
                        hearing,
                        speechChanges,
                        focalWeakness,
                        ed)
        );

        return "UPDATE: Reviewofsymptoms identified by ID "+id+" successfully updated.";
    }

}
