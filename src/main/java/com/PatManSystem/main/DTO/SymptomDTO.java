package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private Integer symptomId;
    private String detail;

    public SymptomDTO(Integer id, Integer symptomId, String detail) {
        this.id = id;
        this.symptomId = symptomId;
        this.detail = detail;
    }
}
