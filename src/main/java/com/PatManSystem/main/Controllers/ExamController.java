package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Services.ExamService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/exam")
@CrossOrigin("*")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) { this.examService = examService;}

    @GetMapping(path ="/all")
    public List<ExamDTO> getExams(){
        return examService.getExams();
    }

    @GetMapping(path ="/id={id}")
    public ExamDTO getExam(@PathVariable("id") Integer id){
        return examService.getExam(id);
    }

    @GetMapping(path ="/uli={ULI}")
    public List<ExamDTO> getExams(@PathVariable("ULI") Long ULI){
        return examService.getExamByULI(ULI);
    }

    @PostMapping(path = "/new")
    public String registerNewExam(@RequestBody ExamDTO examDTO){
        examService.newExam(examDTO);
        return "NEW: Exam identified by ID "+examDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteExam(@PathVariable("id") int id){
        examService.deleteExam(id);
        return "DELETE: Exam identified by ID "+id+" successfully deleted.";
    }

    /*@PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateExam(@RequestBody ExamDTO examDTO){
        examService.updateExam(examDTO);

        return "UPDATE: Exam identified by ULI "+examDTO.getId()+" successfully updated.";
    }

    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateExam(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String ULI

    ){
        patientService.updatePatient(new PatientinformationDTO(id,lastname,firstname,sex,birthday,print,tg,location));

        return "UPDATE: Patient identified by ULI "+id+" successfully updated.";
    }*/

}
