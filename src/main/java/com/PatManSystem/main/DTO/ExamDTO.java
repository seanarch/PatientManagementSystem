package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO implements Serializable {
    private Long id;
    private Integer abdoId;
    private Long uliId;
    private LocalDate date;
    private Integer cnsId;
    private Integer lungId;
    private Integer hnId;
    private Integer oralId;
    private Integer cardiacId;
    private Integer mskId;
    private Integer peripheralId;
    private String abnormal;
    private Integer supineId;
    private Integer breathId;
}
