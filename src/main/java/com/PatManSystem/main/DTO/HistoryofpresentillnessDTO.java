package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryofpresentillnessDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private Integer descriptorId;

    public HistoryofpresentillnessDTO(Integer id, Integer decriptorId) {
        this.id = id;
        this.descriptorId = decriptorId;
    }
}
