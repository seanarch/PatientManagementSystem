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
    private PtId uli;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ECOG")
    private Ecogperformancestatusscale ecog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Swallowing")
    private Mellowscore swallowing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Breathing")
    private Mrcdyspnoeascale breathing;

    public Mrcdyspnoeascale getBreathing() {
        return breathing;
    }

    public void setBreathing(Mrcdyspnoeascale breathing) {
        this.breathing = breathing;
    }

    public Mellowscore getSwallowing() {
        return swallowing;
    }

    public void setSwallowing(Mellowscore swallowing) {
        this.swallowing = swallowing;
    }

    public Ecogperformancestatusscale getEcog() {
        return ecog;
    }

    public void setEcog(Ecogperformancestatusscale ecog) {
        this.ecog = ecog;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}