package com.PatManSystem.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RadiationtherapyDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate dateRTStart;
    private LocalDate dateRTEnd;
    private Integer typeRTId;
    private Integer locationId;
    private Double rTDose;
    private Integer fraction;
    private Integer planningId;
    private String anatDetail;
    private String general;
    private Integer pneumonitisId;
    private Integer upperGIId;
    private Integer skinReactionId;
    private Integer lowerGIId;
    private Integer guId;
    private Integer hemeId;
    private Integer hepaticId;
    private String otherToxicity;
    private String otherToxicityDetail;
    private String details;
    private Integer ng;
}
