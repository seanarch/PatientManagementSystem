package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "phx") // PAST MEDICAL HISTORY
public class Phx {
    @Id
    @Column(name = "PHXID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "FhxDetail", length = 45)
    private String fhxDetail;

    @Column(name = "SmokingPackYears")
    private Integer smokingPackYears;

    @Column(name = "SmokeQuit")
    private Integer smokeQuit;

    @Column(name = "AttendedFamily")
    private Integer attendedFamily;

    @Column(name = "LacksSocialSupport")
    private Integer lacksSocialSupport;

    @Column(name = "LanguageBarrier")
    private Integer languageBarrier;

    @Column(name = "FinanchialChallenge")
    private Integer financhialChallenge;

    @Column(name = "PsychosocialChallenge")
    private Integer psychosocialChallenge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`GOC designation`")
    private Zgoc zgoc;

    @Column(name = "`ETOH/week`", length = 45)
    private String eTOHWeek;

    @Column(name = "Detail", length = 100)
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

    public Zgoc getZgoc() {
        return zgoc;
    }

    public void setZgoc(Zgoc zgoc) {
        this.zgoc = zgoc;
    }

    public Integer getPsychosocialChallenge() {
        return psychosocialChallenge;
    }

    public void setPsychosocialChallenge(Integer psychosocialChallenge) {
        this.psychosocialChallenge = psychosocialChallenge;
    }

    public Integer getFinanchialChallenge() {
        return financhialChallenge;
    }

    public void setFinanchialChallenge(Integer financhialChallenge) {
        this.financhialChallenge = financhialChallenge;
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

    public Integer getSmokeQuit() {
        return smokeQuit;
    }

    public void setSmokeQuit(Integer smokeQuit) {
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

    public PtId getPtId() {
        return ptId;
    }

    public void setPtId(PtId ptId) {
        this.ptId = ptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}