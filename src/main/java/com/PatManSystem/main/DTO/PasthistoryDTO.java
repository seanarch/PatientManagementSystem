package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class PasthistoryDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private String fhxDetail;
    private Integer smokingPackYears;
    private String smokeQuit;
    private Integer attendedFamily;
    private Integer lacksSocialSupport;
    private Integer languageBarrier;
    private Integer financialChallenge;
    private Integer psychosocialChallenge;
    private Integer goalofcareId;
    private String detail;
    private String eTOHWeek;

    public PasthistoryDTO(Integer id, String fhxDetail, Integer smokingPackYears, String smokeQuit, Integer attendedFamily, Integer lacksSocialSupport, Integer languageBarrier, Integer financialChallenge, Integer psychosocialChallenge, Integer goalofcareId, String detail, String eTOHWeek) {

        this.id = id;
        this.fhxDetail = fhxDetail;
        this.smokingPackYears = smokingPackYears;
        this.smokeQuit = smokeQuit;
        this.attendedFamily = attendedFamily;
        this.lacksSocialSupport = lacksSocialSupport;
        this.languageBarrier = languageBarrier;
        this.financialChallenge = financialChallenge;
        this.psychosocialChallenge = psychosocialChallenge;
        this.goalofcareId = goalofcareId;
        this.detail = detail;
        this.eTOHWeek = eTOHWeek;
    }
}
