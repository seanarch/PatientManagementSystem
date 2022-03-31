package com.PatManSystem.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate date;
    private Integer ecogId;
    private Integer swallowingId;
    private Integer breathingId;
}
