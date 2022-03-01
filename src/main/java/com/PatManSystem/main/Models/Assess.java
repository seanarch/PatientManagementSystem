package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assess")
public class Assess {
    @Id
    @Column(name = "WtID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ECOG")
    private Zecog zecog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Swallowing")
    private Zmellow zmellow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Breathing")
    private Zmrc zmrc;

    public Zmrc getZmrc() {
        return zmrc;
    }

    public void setZmrc(Zmrc zmrc) {
        this.zmrc = zmrc;
    }

    public Zmellow getZmellow() {
        return zmellow;
    }

    public void setZmellow(Zmellow zmellow) {
        this.zmellow = zmellow;
    }

    public Zecog getZecog() {
        return zecog;
    }

    public void setZecog(Zecog zecog) {
        this.zecog = zecog;
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