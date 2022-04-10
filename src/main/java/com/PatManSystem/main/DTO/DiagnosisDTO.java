package com.PatManSystem.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private String nodesVe;
    private LocalDate oRDate;
    private Integer locationId;
    private Integer orId;
    private Integer sizePrimaryMm;
    private Integer pathologyId;
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
    private String siteOfFirstMet;
    private LocalDate today;

    public DiagnosisDTO(Integer id, String nodesVe, LocalDate oRDate, Integer locationId, Integer orId, Integer sizePrimaryMm, Integer pathologyId, String grade, String margin, Integer lvsi, Integer periNeural, String t, String nodesTaken, String n, String m, String stainingVeIHC, String stage, Integer recurId, LocalDate today) {

        this.id = id;
        this.nodesVe = nodesVe;
        this.oRDate = oRDate;
        this.locationId = locationId;
        this.orId = orId;
        this.sizePrimaryMm = sizePrimaryMm;
        this.pathologyId = pathologyId;
        this.grade = grade;
        this.margin = margin;
        this.lvsi = lvsi;
        this.periNeural = periNeural;
        this.t = t;
        this.nodesTaken = nodesTaken;
        this.n = n;
        this.m = m;
        this.stainingVeIHC = stainingVeIHC;
        this.stage = stage;
        this.recurId = recurId;
        this.today = today;

    }
}
