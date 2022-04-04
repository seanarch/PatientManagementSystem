package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

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

	public ExamDTO(Long id, Integer abdoId, LocalDate date, Integer cnsId, Integer lungId, Integer hnId, Integer oralId, Integer cardiacId, Integer mskId, Integer peripheralId, String abnormal, Integer supineId, Integer breathId) {
        this.id = id;
        this.abdoId = abdoId;
        this.date = date;
        this.cnsId = cnsId;
        this.lungId = lungId;
        this.hnId = hnId;
        this.oralId = oralId;
        this.cardiacId = cardiacId;
        this.mskId = mskId;
        this.peripheralId = peripheralId;
        this.abnormal = abnormal;
        this.supineId = supineId;
        this.breathId = breathId;
    }

}