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
    private CentralNervousSystem zpxCns;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lung")
    private Lung zpxLung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HN")
    private HeadAndNeck zpxHn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Oral")
    private Oral zpxOral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cardiac")
    private Cardiac zpxCardiac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSK")
    private Musculoskeletal zpxMsk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Peripheral")
    private Skin zpxSkin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Abdo")
    private Abdomen zpxAbdo;

    @Column(name = "ABNORMAL", length = 100)
    private String abnormal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Supine")
    private Supine zsupine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Breath")
    private Breath zbreath;

    public Breath getBreath() {
        return zbreath;
    }

    public void setBreath(Breath zbreath) {
        this.zbreath = zbreath;
    }

    public Supine getSupine() {
        return zsupine;
    }

    public void setSupine(Supine zsupine) {
        this.zsupine = zsupine;
    }

    public String getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
    }

    public Abdomen getAbdomen() {
        return zpxAbdo;
    }

    public void setAbdomen(Abdomen zpxAbdo) {
        this.zpxAbdo = zpxAbdo;
    }

    public Skin getSkin() {
        return zpxSkin;
    }

    public void setSkin(Skin zpxSkin) {
        this.zpxSkin = zpxSkin;
    }

    public Musculoskeletal getMusculoskeletal() {
        return zpxMsk;
    }

    public void setMusculoskeletal(Musculoskeletal zpxMsk) {
        this.zpxMsk = zpxMsk;
    }

    public Cardiac getCardiac() {
        return zpxCardiac;
    }

    public void setCardiac(Cardiac zpxCardiac) {
        this.zpxCardiac = zpxCardiac;
    }

    public Oral getOral() {
        return zpxOral;
    }

    public void setOral(Oral zpxOral) {
        this.zpxOral = zpxOral;
    }

    public HeadAndNeck getHeadAndNeck() {
        return zpxHn;
    }

    public void setHeadAndNeck(HeadAndNeck zpxHn) {
        this.zpxHn = zpxHn;
    }

    public Lung getLung() {
        return zpxLung;
    }

    public void setLung(Lung zpxLung) {
        this.zpxLung = zpxLung;
    }

    public CentralNervousSystem getCentralNervousSystem() {
        return zpxCns;
    }

    public void setCentralNervousSystem(CentralNervousSystem zpxCns) {
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
