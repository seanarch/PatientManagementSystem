package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PulmonaryfunctiontestDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate date;
    private Double fvc;
    private Integer fvc1;
    private Double fev1;
    private Integer fev11;
    private Integer ratio;
    private Integer dlco;
}
