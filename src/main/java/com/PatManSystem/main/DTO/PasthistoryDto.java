package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasthistoryDto implements Serializable {
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
    private Integer gOCDesignationId;
    private String eTOHWeek;
    private String detail;
}
