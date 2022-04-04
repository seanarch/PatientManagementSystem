package com.PatManSystem.main.DTO;

import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
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

    public ChildpughDTO(Integer id){
        this.id = id;
    }
}
