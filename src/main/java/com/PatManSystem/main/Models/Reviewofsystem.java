package com.PatManSystem.main.Models;

import com.PatManSystem.main.Models.PtId;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reviewofsystems")
public class Reviewofsystem {
    @Id
    @Column(name = "ROS", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "`Fevers / Chills`")
    private Integer feversChills;

    @Column(name = "BADLs")
    private Integer bADLs;

    @Column(name = "IADLs")
    private Integer iADLs;

    @Column(name = "`Appetite Loss`")
    private Integer appetiteLoss;

    @Column(name = "`Difficulty Chewing`")
    private Integer difficultyChewing;

    @Column(name = "`Abdominal Pain`")
    private Integer abdominalPain;

    @Column(name = "NauseaVomiting")
    private Integer nauseaVomiting;

    @Column(name = "Heartburn")
    private Integer heartburn;

    @Column(name = "Constipation")
    private Integer constipation;

    @Column(name = "Hemetemesis")
    private Integer hemetemesis;

    @Column(name = "Melena")
    private Integer melena;

    @Column(name = "RectalBleed")
    private Integer rectalBleed;

    @Column(name = "Nocturea")
    private Integer nocturea;

    @Column(name = "Hesitancy")
    private Integer hesitancy;

    @Column(name = "Hematurea")
    private Integer hematurea;

    @Column(name = "Pneumaturea")
    private Integer pneumaturea;

    @Column(name = "`Back BoneJointPain`")
    private Integer backBoneJointPain;

    @Column(name = "SOB")
    private Integer sob;

    @Column(name = "Cough")
    private Integer cough;

    @Column(name = "Hemoptisis")
    private Integer hemoptisis;

    @Column(name = "Wheeze")
    private Integer wheeze;

    @Column(name = "ChestPain")
    private Integer chestPain;

    @Column(name = "Headaches")
    private Integer headaches;

    @Column(name = "VisionChanges")
    private Integer visionChanges;

    @Column(name = "Hearing")
    private Integer hearing;

    @Column(name = "SpeechChanges")
    private Integer speechChanges;

    @Column(name = "FocalWeakness")
    private Integer focalWeakness;

    @Column(name = "ED")
    private Integer ed;

    public Integer getEd() {
        return ed;
    }

    public void setEd(Integer ed) {
        this.ed = ed;
    }

    public Integer getFocalWeakness() {
        return focalWeakness;
    }

    public void setFocalWeakness(Integer focalWeakness) {
        this.focalWeakness = focalWeakness;
    }

    public Integer getSpeechChanges() {
        return speechChanges;
    }

    public void setSpeechChanges(Integer speechChanges) {
        this.speechChanges = speechChanges;
    }

    public Integer getHearing() {
        return hearing;
    }

    public void setHearing(Integer hearing) {
        this.hearing = hearing;
    }

    public Integer getVisionChanges() {
        return visionChanges;
    }

    public void setVisionChanges(Integer visionChanges) {
        this.visionChanges = visionChanges;
    }

    public Integer getHeadaches() {
        return headaches;
    }

    public void setHeadaches(Integer headaches) {
        this.headaches = headaches;
    }

    public Integer getChestPain() {
        return chestPain;
    }

    public void setChestPain(Integer chestPain) {
        this.chestPain = chestPain;
    }

    public Integer getWheeze() {
        return wheeze;
    }

    public void setWheeze(Integer wheeze) {
        this.wheeze = wheeze;
    }

    public Integer getHemoptisis() {
        return hemoptisis;
    }

    public void setHemoptisis(Integer hemoptisis) {
        this.hemoptisis = hemoptisis;
    }

    public Integer getCough() {
        return cough;
    }

    public void setCough(Integer cough) {
        this.cough = cough;
    }

    public Integer getSob() {
        return sob;
    }

    public void setSob(Integer sob) {
        this.sob = sob;
    }

    public Integer getBackBoneJointPain() {
        return backBoneJointPain;
    }

    public void setBackBoneJointPain(Integer backBoneJointPain) {
        this.backBoneJointPain = backBoneJointPain;
    }

    public Integer getPneumaturea() {
        return pneumaturea;
    }

    public void setPneumaturea(Integer pneumaturea) {
        this.pneumaturea = pneumaturea;
    }

    public Integer getHematurea() {
        return hematurea;
    }

    public void setHematurea(Integer hematurea) {
        this.hematurea = hematurea;
    }

    public Integer getHesitancy() {
        return hesitancy;
    }

    public void setHesitancy(Integer hesitancy) {
        this.hesitancy = hesitancy;
    }

    public Integer getNocturea() {
        return nocturea;
    }

    public void setNocturea(Integer nocturea) {
        this.nocturea = nocturea;
    }

    public Integer getRectalBleed() {
        return rectalBleed;
    }

    public void setRectalBleed(Integer rectalBleed) {
        this.rectalBleed = rectalBleed;
    }

    public Integer getMelena() {
        return melena;
    }

    public void setMelena(Integer melena) {
        this.melena = melena;
    }

    public Integer getHemetemesis() {
        return hemetemesis;
    }

    public void setHemetemesis(Integer hemetemesis) {
        this.hemetemesis = hemetemesis;
    }

    public Integer getConstipation() {
        return constipation;
    }

    public void setConstipation(Integer constipation) {
        this.constipation = constipation;
    }

    public Integer getHeartburn() {
        return heartburn;
    }

    public void setHeartburn(Integer heartburn) {
        this.heartburn = heartburn;
    }

    public Integer getNauseaVomiting() {
        return nauseaVomiting;
    }

    public void setNauseaVomiting(Integer nauseaVomiting) {
        this.nauseaVomiting = nauseaVomiting;
    }

    public Integer getAbdominalPain() {
        return abdominalPain;
    }

    public void setAbdominalPain(Integer abdominalPain) {
        this.abdominalPain = abdominalPain;
    }

    public Integer getDifficultyChewing() {
        return difficultyChewing;
    }

    public void setDifficultyChewing(Integer difficultyChewing) {
        this.difficultyChewing = difficultyChewing;
    }

    public Integer getAppetiteLoss() {
        return appetiteLoss;
    }

    public void setAppetiteLoss(Integer appetiteLoss) {
        this.appetiteLoss = appetiteLoss;
    }

    public Integer getIADLs() {
        return iADLs;
    }

    public void setIADLs(Integer iADLs) {
        this.iADLs = iADLs;
    }

    public Integer getBADLs() {
        return bADLs;
    }

    public void setBADLs(Integer bADLs) {
        this.bADLs = bADLs;
    }

    public Integer getFeversChills() {
        return feversChills;
    }

    public void setFeversChills(Integer feversChills) {
        this.feversChills = feversChills;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PtId getUli() {
        return uli;
    }

    public void setUli(PtId uli) {
        this.uli = uli;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}