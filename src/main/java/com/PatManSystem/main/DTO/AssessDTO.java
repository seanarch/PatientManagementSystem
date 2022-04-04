package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate date;
    private Integer ecogId;
    private String ecogDescription;
    private Integer swallowingId;
    private String swallowingDescription;
    private Integer breathingId;
    private String breathingDescription;

    public AssessDTO(Integer id, LocalDate date, Integer ecogId, Integer swallowingId, Integer breathingId) {
        this.id = id;
        this.date = date;
        this.ecogId = ecogId;
        this.swallowingId = swallowingId;
        this.breathingId = breathingId;
    }
}
