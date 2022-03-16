package com.PatManSystem.main.Repository;

import com.PatManSystem.main.DTO.PtIdDto;

import com.PatManSystem.main.Mapper.PtIdMapperImpl;
import com.PatManSystem.main.Models.Patientinformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PtIDMapperImplTest {

    @Autowired
    private final PtIdMapperImpl  mapper = new PtIdMapperImpl();

    @Test
    void ptIdDtoToPtIdTest(){

        PtIdDto ptIdDto = new PtIdDto();
        //set up ptIdDto

        ptIdDto.setId(235878);
        ptIdDto.setFirstname("Jack");
        ptIdDto.setLastname("Bauer");
        ptIdDto.setSex('M');
        ptIdDto.setBirthday(LocalDate.ofEpochDay(2020-12-12));
        ptIdDto.setLocation("Calgary");
        ptIdDto.setTg("TG");
        ptIdDto.setPrint(1);

        Patientinformation patientinformationModel = mapper.ptIdDtoToPtId(ptIdDto);

        assertEquals(ptIdDto.getId(), patientinformationModel.getId());
        assertEquals(ptIdDto.getFirstname(), patientinformationModel.getFirstname());
        assertEquals(ptIdDto.getLastname(), patientinformationModel.getLastname());
        assertEquals(ptIdDto.getSex(), patientinformationModel.getSex());
        assertEquals(ptIdDto.getBirthday(), patientinformationModel.getBirthday());
        assertEquals(ptIdDto.getLocation(), patientinformationModel.getLocation());
        assertEquals(ptIdDto.getTg(), patientinformationModel.getTg());
        assertEquals(ptIdDto.getPrint(), patientinformationModel.getPrint());
    }
}
