package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
@Setter
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

    public RadiationtherapyDTO(Integer id, LocalDate dateRTStart, LocalDate dateRTEnd, Integer typeRTId, Integer locationId, Double rTDose, Integer fraction, Integer planningId, String anatDetail, String general, Integer pneumonitisId, Integer upperGIId, Integer skinReactionId, Integer lowerGIId, Integer guId, Integer hemeId, Integer hepaticId, String otherToxicity, String details, Integer ng) {
        this.id = id;
        this.dateRTStart = dateRTStart;
        this.dateRTEnd = dateRTEnd;
        this.typeRTId = typeRTId;
        this.locationId = locationId;
        this.rTDose = rTDose;
        this.fraction = fraction;
        this.planningId = planningId;
        this.anatDetail = anatDetail;
        this.general = general;
        this.pneumonitisId = pneumonitisId;
        this.upperGIId = upperGIId;
        this.skinReactionId = skinReactionId;
        this.lowerGIId = lowerGIId;
        this.guId = guId;
        this.hemeId = hemeId;
        this.hepaticId = hepaticId;
        this.otherToxicity = otherToxicity;
        this.details = details;
        this.ng = ng;
    }
}
