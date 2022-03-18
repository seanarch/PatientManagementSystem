package com.PatManSystem.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisDto implements Serializable {
    private Integer id;
    private Long uliId;
    private String nodesVe;
    private LocalDate oRDate;
    private Integer locationId;
    private Integer orId;
    private String orDescription;
    private Integer sizePrimaryMm;
    private Integer pathologyId;
    private String pathologyDescription;
    private String grade;
    private String margin;
    private Integer lvsi;
    private Integer periNeural;
    private String t;
    private String nodesTaken;
    private String n;
    private String m;
    private String stainingVeIHC;
    private String stage;
    private Integer recurId;
    private String recurDescription;
    private String siteOfFirstMet;
    private LocalDate today;
}
