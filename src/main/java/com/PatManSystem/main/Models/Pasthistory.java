package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "pasthistory")
public class Pasthistory {
    @Id
    @Column(name = "PHx", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getETOHWeek() {
        return eTOHWeek;
    }

    public void setETOHWeek(String eTOHWeek) {
        this.eTOHWeek = eTOHWeek;
    }

    public Goalofcare getGOCDesignation() {
        return gOCDesignation;
    }

    public void setGOCDesignation(Goalofcare gOCDesignation) {
        this.gOCDesignation = gOCDesignation;
    }

    public Integer getPsychosocialChallenge() {
        return psychosocialChallenge;
    }

    public void setPsychosocialChallenge(Integer psychosocialChallenge) {
        this.psychosocialChallenge = psychosocialChallenge;
    }

    public Integer getFinancialChallenge() {
        return financialChallenge;
    }

    public void setFinancialChallenge(Integer financialChallenge) {
        this.financialChallenge = financialChallenge;
    }

    public Integer getLanguageBarrier() {
        return languageBarrier;
    }

    public void setLanguageBarrier(Integer languageBarrier) {
        this.languageBarrier = languageBarrier;
    }

    public Integer getLacksSocialSupport() {
        return lacksSocialSupport;
    }

    public void setLacksSocialSupport(Integer lacksSocialSupport) {
        this.lacksSocialSupport = lacksSocialSupport;
    }

    public Integer getAttendedFamily() {
        return attendedFamily;
    }

    public void setAttendedFamily(Integer attendedFamily) {
        this.attendedFamily = attendedFamily;
    }

    public String getSmokeQuit() {
        return smokeQuit;
    }

    public void setSmokeQuit(String smokeQuit) {
        this.smokeQuit = smokeQuit;
    }

    public Integer getSmokingPackYears() {
        return smokingPackYears;
    }

    public void setSmokingPackYears(Integer smokingPackYears) {
        this.smokingPackYears = smokingPackYears;
    }

    public String getFhxDetail() {
        return fhxDetail;
    }

    public void setFhxDetail(String fhxDetail) {
        this.fhxDetail = fhxDetail;
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