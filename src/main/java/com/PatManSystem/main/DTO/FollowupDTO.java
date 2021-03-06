package com.PatManSystem.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowupDTO implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate date;
    private Integer typeFUId;
    private Integer clinicalResponseId;
    private Integer pneumonitisId;
    private Integer upperGIId;
    private Integer skinReactionId;
    private Integer lowerGIId;
    private Integer guId;
    private Integer hemeId;
    private Integer hepaticId;
    private String otherToxicity;
    private String otherToxDetail;

    public FollowupDTO(Integer id, LocalDate date, Integer typeFUId, Integer clinicalResponseId, Integer pneumonitisId, Integer upperGIId, Integer skinReactionId, Integer lowerGIId, Integer guId, Integer hemeId, Integer hepaticId, String otherToxicity, String otherToxDetail) {
        this.id = id;
        this.date = date;
        this.typeFUId = typeFUId;
        this. clinicalResponseId = clinicalResponseId;
        this. pneumonitisId = pneumonitisId;
        this. upperGIId = upperGIId;
        this. skinReactionId = skinReactionId;
        this. lowerGIId = lowerGIId;
        this. guId = guId;
        this. hemeId = hemeId;
        this. hepaticId = hepaticId;
        this. otherToxicity = otherToxicity;
        this. otherToxDetail = otherToxDetail;
    }
}
