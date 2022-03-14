package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(name = "Exam", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Abdo")
    private Abdomen abdo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CNS")
    private Centralnervoussystem cns;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lung")
    private Lung lung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HN")
    private Headandneck hn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Oral")
    private Oral oral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cardiac")
    private Cardiac cardiac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSK")
    private Musculoskeletal msk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Peripheral")
    private Skin peripheral;

    @Column(name = "ABNORMAL", length = 2000)
    private String abnormal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Supine")
    private Supine supine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Breath")
    private Breath breath;

    public Breath getBreath() {
        return breath;
    }

    public void setBreath(Breath breath) {
        this.breath = breath;
    }

    public Supine getSupine() {
        return supine;
    }

    public void setSupine(Supine supine) {
        this.supine = supine;
    }

    public String getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(String abnormal) {
        this.abnormal = abnormal;
    }

    public Skin getPeripheral() {
        return peripheral;
    }

    public void setPeripheral(Skin peripheral) {
        this.peripheral = peripheral;
    }

    public Musculoskeletal getMsk() {
        return msk;
    }

    public void setMsk(Musculoskeletal msk) {
        this.msk = msk;
    }

    public Cardiac getCardiac() {
        return cardiac;
    }

    public void setCardiac(Cardiac cardiac) {
        this.cardiac = cardiac;
    }

    public Oral getOral() {
        return oral;
    }

    public void setOral(Oral oral) {
        this.oral = oral;
    }

    public Headandneck getHn() {
        return hn;
    }

    public void setHn(Headandneck hn) {
        this.hn = hn;
    }

    public Lung getLung() {
        return lung;
    }

    public void setLung(Lung lung) {
        this.lung = lung;
    }

    public Centralnervoussystem getCns() {
        return cns;
    }

    public void setCns(Centralnervoussystem cns) {
        this.cns = cns;
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

    public Abdomen getAbdo() {
        return abdo;
    }

    public void setAbdo(Abdomen abdo) {
        this.abdo = abdo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}