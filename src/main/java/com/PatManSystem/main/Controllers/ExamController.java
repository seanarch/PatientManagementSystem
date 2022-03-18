package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.ExamDto;
import com.PatManSystem.main.Services.ExamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/exam")
@CrossOrigin("*")
public class ExamController {
    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping(path ="/all")
    public List<ExamDto> getExams(){
        return examService.getExams();
    }
}
