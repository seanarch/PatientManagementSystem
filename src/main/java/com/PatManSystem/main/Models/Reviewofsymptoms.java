package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "reviewofsymptoms")
public class Reviewofsymptoms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "Nauseavomiting")
    private Integer nauseaVomiting;

    @Column(name = "Heartburn")
    private Integer heartburn;

    @Column(name = "Constipation")
    private Integer constipation;

    @Column(name = "Hemetemesis")
    private Integer hemetemesis;

    @Column(name = "Melena")
    private Integer melena;

    @Column(name = "Rectalbleed")
    private Integer rectalBleed;

    @Column(name = "Nocturea")
    private Integer nocturea;

    @Column(name = "Hesitancy")
    private Integer hesitancy;

    @Column(name = "Hematurea")
    private Integer hematurea;

    @Column(name = "Pneumaturea")
    private Integer pneumaturea;

    @Column(name = "`Back Bonejointpain`")
    private Integer backBoneJointPain;

    @Column(name = "SOB")
    private Integer sob;

    @Column(name = "Cough")
    private Integer cough;

    @Column(name = "Hemoptisis")
    private Integer hemoptisis;

    @Column(name = "Wheeze")
    private Integer wheeze;

    @Column(name = "Chestpain")
    private Integer chestPain;

    @Column(name = "Headaches")
    private Integer headaches;

    @Column(name = "Visionchanges")
    private Integer visionChanges;

    @Column(name = "Hearing")
    private Integer hearing;

    @Column(name = "Speechchanges")
    private Integer speechChanges;

    @Column(name = "Focalweakness")
    private Integer focalWeakness;

    @Column(name = "ED")
    private Integer ed;

}