package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "reviewofsystems")
public class Reviewofsystem {
    @Id
    @Column(name = "ROS", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

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

}