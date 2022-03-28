package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Services.ExamService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public ExamDTO getExam(@PathVariable("id") Long id){
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
    public String deleteExam(@PathVariable("id") Long id){
        examService.deleteExam(id);
        return "DELETE: Exam identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateExam(@RequestBody ExamDTO examDTO){

        examService.updateExam(examDTO);
        return "UPDATE: Exam identified by ULI "+examDTO.getId()+" successfully updated.";

    }

    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateExam(
        @PathVariable("id") Long id,
        @RequestParam(required = false) Integer abdoId,
        @RequestParam(required = false) String abdoDescription,
        @RequestParam(required = false) Long uliId,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, // date parsed from JSON is STRING, addition formatting required to convert to LocalDate Obj
        @RequestParam(required = false) Integer cnsId,
        @RequestParam(required = false) String cnsDescription,
        @RequestParam(required = false) Integer lungId,
        @RequestParam(required = false) String lungDescription,
        @RequestParam(required = false) Integer hnId,
        @RequestParam(required = false) String hnDescription,
        @RequestParam(required = false) Integer oralId,
        @RequestParam(required = false) String oralDescription,
        @RequestParam(required = false) Integer cardiacId,
        @RequestParam(required = false) String cardiacDescription,
        @RequestParam(required = false) Integer mskId,
        @RequestParam(required = false) String mskDescription,
        @RequestParam(required = false) Integer peripheralId,
        @RequestParam(required = false) String peripheralDescription,
        @RequestParam(required = false) String abnormal,
        @RequestParam(required = false) Integer supineId,
        @RequestParam(required = false) String supineDescription,
        @RequestParam(required = false) Integer breathId,
        @RequestParam(required = false) String breathDescription
    ){
        examService.updateExam(new ExamDTO(id,abdoId,abdoDescription,uliId,date,cnsId,cnsDescription,
                lungId,lungDescription,hnId,hnDescription,oralId,oralDescription,cardiacId,cardiacDescription,
                mskId,mskDescription,peripheralId,peripheralDescription,abnormal,supineId,supineDescription,breathId,breathDescription));

        return "UPDATE: Exam identified by ID "+id+" successfully updated.";
    }

}
