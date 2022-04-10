package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticimagingDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate dateDI;
    private Integer typeDIId;
    private String finding;

    public DiagnosticimagingDTO(Integer id, LocalDate dateDI, Integer typeDIId, String finding) {
        this.id = id;
        this.dateDI = dateDI;
        this.typeDIId = typeDIId;
        this.finding = finding;
    }
}
