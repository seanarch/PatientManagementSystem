package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(name = "Exam", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CNS")
    private ZpxCn zpxCns;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lung")
    private ZpxLung zpxLung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HN")
    private ZpxHn zpxHn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Oral")
    private ZpxOral zpxOral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cardiac")
    private ZpxCardiac zpxCardiac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSK")
    private ZpxMsk zpxMsk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Peripheral")
    private ZpxSkin zpxSkin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Abdo")
    private ZpxAbdo zpxAbdo;

    @Column(name = "ABNORMAL", length = 100)
    private String abnormal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Supine")
    private Zsupine zsupine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Breath")
    private Zbreath zbreath;

    public Zbreath getZbreath() {
        return zbreath;
    }

    public void setZbreath(Zbreath zbreath) {
        this.zbreath = zbreath;
    }

    public Zsupine getZsupine() {
        return zsupine;
    }

    public void setZsupine(Zsupine zsupine) {
        this.zsupine = zsupine;
    }

    public String getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
    }

    public ZpxAbdo getZpxAbdo() {
        return zpxAbdo;
    }

    public void setZpxAbdo(ZpxAbdo zpxAbdo) {
        this.zpxAbdo = zpxAbdo;
    }

    public ZpxSkin getZpxSkin() {
        return zpxSkin;
    }

    public void setZpxSkin(ZpxSkin zpxSkin) {
        this.zpxSkin = zpxSkin;
    }

    public ZpxMsk getZpxMsk() {
        return zpxMsk;
    }

    public void setZpxMsk(ZpxMsk zpxMsk) {
        this.zpxMsk = zpxMsk;
    }

    public ZpxCardiac getZpxCardiac() {
        return zpxCardiac;
    }

    public void setZpxCardiac(ZpxCardiac zpxCardiac) {
        this.zpxCardiac = zpxCardiac;
    }

    public ZpxOral getZpxOral() {
        return zpxOral;
    }

    public void setZpxOral(ZpxOral zpxOral) {
        this.zpxOral = zpxOral;
    }

    public ZpxHn getZpxHn() {
        return zpxHn;
    }

    public void setZpxHn(ZpxHn zpxHn) {
        this.zpxHn = zpxHn;
    }

    public ZpxLung getZpxLung() {
        return zpxLung;
    }

    public void setZpxLung(ZpxLung zpxLung) {
        this.zpxLung = zpxLung;
    }

    public ZpxCn getZpxCns() {
        return zpxCns;
    }

    public void setZpxCns(ZpxCn zpxCns) {
        this.zpxCns = zpxCns;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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