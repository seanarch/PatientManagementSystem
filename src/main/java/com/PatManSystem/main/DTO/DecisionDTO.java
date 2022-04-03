package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecisionDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private Integer decisionId;
    private String decisionDescription;
    private String detail;


    public DecisionDTO(Integer id, Integer decisionId, String detail) {
        this.id = id;
        this.decisionId = decisionId;
        this.detail = detail;
    }
}
