package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "symptom")
public class Symptom {
    @Id
    @Column(name = "SxID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Symptom")
    private Typeofsymptom symptom;

    @Column(name = "Detail", length = 1000)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Typeofsymptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Typeofsymptom symptom) {
        this.symptom = symptom;
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
