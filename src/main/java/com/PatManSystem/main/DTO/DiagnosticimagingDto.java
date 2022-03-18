package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticimagingDto implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate dateDI;
    private Integer typeDIId;
    private String typeDIDescription;
    private String finding;
}
