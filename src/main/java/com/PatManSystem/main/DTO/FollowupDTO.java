package com.PatManSystem.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
