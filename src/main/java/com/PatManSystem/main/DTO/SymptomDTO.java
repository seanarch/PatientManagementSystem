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
    private String symptomDecription;
    private String detail;
}
