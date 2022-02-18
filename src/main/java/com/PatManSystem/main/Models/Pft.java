package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pft")
public class Pft {
    @Id
    @Column(name = "PFT", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "FVC")
    private Double fvc;

    @Column(name = "`FVC%`")
    private Integer fvc1;

    @Column(name = "FEV1")
    private Double fev1;

    @Column(name = "`FEV1%`")
    private Integer fev11;

    @Column(name = "Ratio")
    private Integer ratio;

    @Column(name = "DLCO")
    private Integer dlco;

    public Integer getDlco() {
        return dlco;
    }

    public void setDlco(Integer dlco) {
        this.dlco = dlco;
    }

    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }

    public Integer getFev11() {
        return fev11;
    }

    public void setFev11(Integer fev11) {
        this.fev11 = fev11;
    }

    public Double getFev1() {
        return fev1;
    }

    public void setFev1(Double fev1) {
        this.fev1 = fev1;
    }

    public Integer getFvc1() {
        return fvc1;
    }

    public void setFvc1(Integer fvc1) {
        this.fvc1 = fvc1;
    }

    public Double getFvc() {
        return fvc;
    }

    public void setFvc(Double fvc) {
        this.fvc = fvc;
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