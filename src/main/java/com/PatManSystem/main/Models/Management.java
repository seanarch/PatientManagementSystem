package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "management")
public class Management {
    @Id
    @Column(name = "MNG", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Intervention")
    private Typeofmanagement intervention;

    @Column(name = "Detail", length = 5000)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Typeofmanagement getIntervention() {
        return intervention;
    }

    public void setIntervention(Typeofmanagement intervention) {
        this.intervention = intervention;
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