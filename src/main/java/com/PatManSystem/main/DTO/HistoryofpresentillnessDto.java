package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryofpresentillnessDto implements Serializable {
    private Integer id;
    private Long uliId;
    private Integer descriptorId;
    private String descriptorDescription;
}
