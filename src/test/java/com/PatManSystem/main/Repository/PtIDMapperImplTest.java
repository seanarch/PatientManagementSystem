package com.PatManSystem.main.Repository;

import com.PatManSystem.main.DTO.PatientinformationDto;
import com.PatManSystem.main.Mapper.PatientinformationMapperImpl;
import com.PatManSystem.main.Models.Patientinformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PtIDMapperImplTest {

    @Autowired
    private final PatientinformationMapperImpl mapper = new PatientinformationMapperImpl();

    @Test
    void ptIdDtoToPtIdTest(){

        PatientinformationDto patientinformationDTO = new PatientinformationDto();
        //set up ptIdDto

        patientinformationDTO.setId(235878L);
        patientinformationDTO.setFirstname("Jack");
        patientinformationDTO.setLastname("Bauer");
        patientinformationDTO.setSex('M');
        patientinformationDTO.setBirthday(LocalDate.ofEpochDay(2020-12-12));
        patientinformationDTO.setLocation("Calgary");
        patientinformationDTO.setTg("TG");
        patientinformationDTO.setPrint(1);

        Patientinformation patientinformationModel = mapper.patientinformationDtoToPatientinformation(patientinformationDTO);

        assertEquals(patientinformationDTO.getId(), patientinformationModel.getId());
        assertEquals(patientinformationDTO.getFirstname(), patientinformationModel.getFirstname());
        assertEquals(patientinformationDTO.getLastname(), patientinformationModel.getLastname());
        assertEquals(patientinformationDTO.getSex(), patientinformationModel.getSex());
        assertEquals(patientinformationDTO.getBirthday(), patientinformationModel.getBirthday());
        assertEquals(patientinformationDTO.getLocation(), patientinformationModel.getLocation());
        assertEquals(patientinformationDTO.getTg(), patientinformationModel.getTg());
        assertEquals(patientinformationDTO.getPrint(), patientinformationModel.getPrint());
    }
}
