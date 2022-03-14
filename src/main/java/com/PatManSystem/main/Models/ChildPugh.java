package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "childpugh")
public class ChildPugh {
    @Id
    @Column(name = "CPID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "`Total Bili (umol/l)`")
    private Integer totalBiliUmolL;

    @Column(name = "`Serum Alb (g/l)`")
    private Integer serumAlbGL;

    @Column(name = "`PT INR`")
    private Double ptInr;

    @Column(name = "Ascites", length = 45)
    private String ascites;

    @Column(name = "`Hepatic Ench`", length = 45)
    private String hepaticEnch;

    @Column(name = "`Child Pugh Score`")
    private Integer childPughScore;

    @Column(name = "`Child Pugh`", length = 1)
    private String childPugh;

    public String getChildPugh() {
        return childPugh;
    }

    public void setChildPugh(String childPugh) {
        this.childPugh = childPugh;
    }

    public Integer getChildPughScore() {
        return childPughScore;
    }

    public void setChildPughScore(Integer childPughScore) {
        this.childPughScore = childPughScore;
    }

    public String getHepaticEnch() {
        return hepaticEnch;
    }

    public void setHepaticEnch(String hepaticEnch) {
        this.hepaticEnch = hepaticEnch;
    }

    public String getAscites() {
        return ascites;
    }

    public void setAscites(String ascites) {
        this.ascites = ascites;
    }

    public Double getPtInr() {
        return ptInr;
    }

    public void setPtInr(Double ptInr) {
        this.ptInr = ptInr;
    }

    public Integer getSerumAlbGL() {
        return serumAlbGL;
    }

    public void setSerumAlbGL(Integer serumAlbGL) {
        this.serumAlbGL = serumAlbGL;
    }

    public Integer getTotalBiliUmolL() {
        return totalBiliUmolL;
    }

    public void setTotalBiliUmolL(Integer totalBiliUmolL) {
        this.totalBiliUmolL = totalBiliUmolL;
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