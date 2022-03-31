package com.PatManSystem.main.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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