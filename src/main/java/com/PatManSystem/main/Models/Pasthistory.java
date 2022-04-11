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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHx", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "Fhxdetail", length = 500)
    private String fhxDetail;

    @Column(name = "Smokingpackyears")
    private Integer smokingPackYears;

    @Column(name = "Smokequit", length = 45)
    private String smokeQuit;

    @Column(name = "Attendedfamily")
    private Integer attendedFamily;

    @Column(name = "Lackssocialsupport")
    private Integer lacksSocialSupport;

    @Column(name = "Languagebarrier")
    private Integer languageBarrier;

    @Column(name = "Financialchallenge")
    private Integer financialChallenge;

    @Column(name = "Psychosocialchallenge")
    private Integer psychosocialChallenge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`GOC designation`")
    private Goalofcare goalofcare;

    @Column(name = "`ETOH/week`", length = 45)
    private String eTOHWeek;

    @Column(name = "Detail", length = 1000)
    private String detail;

}