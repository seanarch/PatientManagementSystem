package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecisionDto implements Serializable {
    private Integer id;
    private Long uliId;
    private Integer decisionId;
    private String decisionDescription;
    private String detail;
}
