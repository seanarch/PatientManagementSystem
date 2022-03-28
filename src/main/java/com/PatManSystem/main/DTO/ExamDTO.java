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
    private String abdoDescription;
    private Long uliId;
    private LocalDate date;
    private Integer cnsId;
    private String cnsDescription;
    private Integer lungId;
    private String lungDescription;
    private Integer hnId;
    private String hnDescription;
    private Integer oralId;
    private String oralDescription;
    private Integer cardiacId;
    private String cardiacDescription;
    private Integer mskId;
    private String mskDescription;
    private Integer peripheralId;
    private String peripheralDescription;
    private String abnormal;
    private Integer supineId;
    private String supineDescription;
    private Integer breathId;
    private String breathDescription;
}
