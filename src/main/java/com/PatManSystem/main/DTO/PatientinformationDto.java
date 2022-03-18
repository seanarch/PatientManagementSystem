package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientinformationDto implements Serializable {
    private Long id;
    private String lastname;
    private String firstname;
    private Character sex;
    private LocalDate birthday;
    private Integer print;
    private String tg;
    private String location;
}
