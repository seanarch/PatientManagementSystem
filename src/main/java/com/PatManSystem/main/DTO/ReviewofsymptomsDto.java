package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewofsymptomsDto implements Serializable {
    private Integer id;
    private Long uliId;
    private LocalDate date;
    private Integer feversChills;
    private Integer bADLs;
    private Integer iADLs;
    private Integer appetiteLoss;
    private Integer difficultyChewing;
    private Integer abdominalPain;
    private Integer nauseaVomiting;
    private Integer heartburn;
    private Integer constipation;
    private Integer hemetemesis;
    private Integer melena;
    private Integer rectalBleed;
    private Integer nocturea;
    private Integer hesitancy;
    private Integer hematurea;
    private Integer pneumaturea;
    private Integer backBoneJointPain;
    private Integer sob;
    private Integer cough;
    private Integer hemoptisis;
    private Integer wheeze;
    private Integer chestPain;
    private Integer headaches;
    private Integer visionChanges;
    private Integer hearing;
    private Integer speechChanges;
    private Integer focalWeakness;
    private Integer ed;
}
