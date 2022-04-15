package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor

@Getter
@Setter
@Data
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

	public ExamDTO(Long id, Integer abdoId, Long uliId, LocalDate date, Integer cnsId, Integer lungId, Integer hnId, Integer oralId, Integer cardiacId, Integer mskId, Integer peripheralId, String abnormal, Integer supineId, Integer breathId) {
        this.id = id;
        this.abdoId = abdoId;
        this.uliId = uliId;
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