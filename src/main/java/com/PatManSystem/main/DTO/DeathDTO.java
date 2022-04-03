package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeathDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate date;
    private String detail;

    public DeathDTO(Integer id, LocalDate date, String detail) {
        this.id = id;
        this.date = date;
        this.detail = detail;
    }
}
