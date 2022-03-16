package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "pasthistory")
public class Pasthistory {
    @Id
    @Column(name = "PHx", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "FhxDetail", length = 500)
    private String fhxDetail;

    @Column(name = "SmokingPackYears")
    private Integer smokingPackYears;

    @Column(name = "SmokeQuit", length = 45)
    private String smokeQuit;

    @Column(name = "AttendedFamily")
    private Integer attendedFamily;

    @Column(name = "LacksSocialSupport")
    private Integer lacksSocialSupport;

    @Column(name = "LanguageBarrier")
    private Integer languageBarrier;

    @Column(name = "FinancialChallenge")
    private Integer financialChallenge;

    @Column(name = "PsychosocialChallenge")
    private Integer psychosocialChallenge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`GOC designation`")
    private Goalofcare gOCDesignation;

    @Column(name = "`ETOH/week`", length = 45)
    private String eTOHWeek;

    @Column(name = "Detail", length = 1000)
    private String detail;

}