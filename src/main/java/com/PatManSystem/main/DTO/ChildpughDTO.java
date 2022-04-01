package com.PatManSystem.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildpughDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate date;
    private Integer totalBiliUmolL;
    private Integer serumAlbGL;
    private Double ptInr;
    private String ascites;
    private String hepaticEnch;
    private Integer childPughScore;
    private String childPugh;
}
