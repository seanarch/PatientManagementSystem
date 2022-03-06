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
    private ECOGPerformanceStatusScale zecog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Swallowing")
    private MellowScore zmellow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Breathing")
    private MRCDyspnoeaScale zmrc;

    public MRCDyspnoeaScale getMRCDyspnoeaScale() {
        return zmrc;
    }

    public void setMRCDyspnoeaScale(MRCDyspnoeaScale zmrc) {
        this.zmrc = zmrc;
    }

    public MellowScore getMellowScore() {
        return zmellow;
    }

    public void setMellowScore(MellowScore zmellow) {
        this.zmellow = zmellow;
    }

    public ECOGPerformanceStatusScale getECOGPerformanceStatusScale() {
        return zecog;
    }

    public void setECOGPerformanceStatusScale(ECOGPerformanceStatusScale zecog) {
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