package com.PatManSystem.main.Repository;

import com.PatManSystem.main.DTO.PtIdDto;

import com.PatManSystem.main.Mapper.PtIdMapperImpl;
import com.PatManSystem.main.Models.PtId;
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

        PtId ptIdModel = mapper.ptIdDtoToPtId(ptIdDto);

        assertEquals(ptIdDto.getId(), ptIdModel.getId());
        assertEquals(ptIdDto.getFirstname(), ptIdModel.getFirstname());
        assertEquals(ptIdDto.getLastname(),ptIdModel.getLastname());
        assertEquals(ptIdDto.getSex(),ptIdModel.getSex());
        assertEquals(ptIdDto.getBirthday(), ptIdModel.getBirthday());
        assertEquals(ptIdDto.getLocation(), ptIdModel.getLocation());
        assertEquals(ptIdDto.getTg(), ptIdModel.getTg());
        assertEquals(ptIdDto.getPrint(), ptIdModel.getPrint());
    }
}
