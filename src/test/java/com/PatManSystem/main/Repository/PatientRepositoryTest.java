package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.PtId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {

    @Autowired
    private PatientRepository  studentRepository;

    /*
    @Test
    public void printAllPatients(){
        List<PtId> ptIdList = studentRepository.findAll();

        for (PtId ptId : ptIdList) System.out.println(((PtId) ptId).getFirstname());
    }
*/
}