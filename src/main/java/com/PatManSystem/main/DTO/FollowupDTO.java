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
    private String typeFUDescription;
    private Integer clinicalResponseId;
    private String clinicalResponseDescription;
    private Integer pneumonitisId;
    private String pneumonitisDescription;
    private Integer upperGIId;
    private String upperGIDescription;
    private Integer skinReactionId;
    private String skinReactionDescription;
    private Integer lowerGIId;
    private String lowerGIDescription;
    private Integer guId;
    private String guDescription;
    private Integer hemeId;
    private String hemeDescription;
    private Integer hepaticId;
    private String hepaticDescription;
    private String otherToxicity;
    private String otherToxDetail;
}
