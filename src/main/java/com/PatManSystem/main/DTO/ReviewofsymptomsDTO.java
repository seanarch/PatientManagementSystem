package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ReviewofsymptomsDTO implements Serializable {
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

    public ReviewofsymptomsDTO(Integer id, LocalDate date, Integer feversChills, Integer bADLs, Integer iADLs, Integer appetiteLoss, Integer difficultyChewing, Integer abdominalPain, Integer nauseaVomiting, Integer heartburn, Integer constipation, Integer hemetemesis, Integer melena, Integer rectalBleed, Integer nocturea, Integer hesitancy, Integer hematurea, Integer pneumaturea, Integer backBoneJointPain, Integer sob, Integer cough, Integer hemoptisis, Integer wheeze, Integer chestPain, Integer headaches, Integer visionChanges, Integer hearing, Integer speechChanges, Integer focalWeakness, Integer ed) {
        this.id = id;
        this.date = date;
        this.feversChills = feversChills;
        this.bADLs = bADLs;
        this.iADLs = iADLs;
        this.appetiteLoss = appetiteLoss;
        this.difficultyChewing = difficultyChewing;
        this.abdominalPain = abdominalPain;
        this.nauseaVomiting = nauseaVomiting;
        this.heartburn = heartburn;
        this.constipation = constipation;
        this.hemetemesis = hemetemesis;
        this.melena = melena;
        this.rectalBleed = rectalBleed;
        this.nocturea = nocturea;
        this.hesitancy = hesitancy;
        this.hematurea = hematurea;
        this.pneumaturea = pneumaturea;
        this.backBoneJointPain = backBoneJointPain;
        this.sob = sob;
        this.cough = cough;
        this.hemoptisis = hemoptisis;
        this.wheeze = wheeze;
        this.chestPain = chestPain;
        this.headaches = headaches;
        this.visionChanges = visionChanges;
        this.hearing = hearing;
        this.speechChanges = speechChanges;
        this.focalWeakness = focalWeakness;
        this.ed = ed;
    }
}
