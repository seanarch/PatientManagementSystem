package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dx", indexes = {
        @Index(name = "ULI_dx_idx", columnList = "ULI")
})
public class Dx {
    @Id
    @Column(name = "`Bx ID`", nullable = false)
    private Integer id;

    @Column(name = "`Nodes +ve`", length = 10)
    private String nodesVe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "`OR Date`")
    private LocalDate oRDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Location")
    private Zlocation zlocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`OR`")
    private Zbx zbx;

    @Column(name = "`Size Primary (mm)`")
    private Integer sizePrimaryMm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pathology")
    private Zpath zpath;

    @Column(name = "Grade", length = 10)
    private String grade;

    @Column(name = "Margin", length = 20)
    private String margin;

    @Column(name = "LVSI")
    private Integer lvsi;

    @Column(name = "`Peri Neural`")
    private Integer periNeural;

    @Column(name = "T", length = 5)
    private String t;

    @Column(name = "`Nodes Taken`", length = 5)
    private String nodesTaken;

    @Column(name = "N", length = 5)
    private String n;

    @Column(name = "M", length = 5)
    private String m;

    @Column(name = "`Staining +ve IHC`", length = 20)
    private String stainingVeIHC;

    @Column(name = "Stage", length = 5)
    private String stage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Recur")
    private Zrecur zrecur;

    @Column(name = "`Site of First Met`", length = 20)
    private String siteOfFirstMet;

    @Column(name = "`Today''s Date`")
    private LocalDate todaySDate;

    public LocalDate getTodaySDate() {
        return todaySDate;
    }

    public void setTodaySDate(LocalDate todaySDate) {
        this.todaySDate = todaySDate;
    }

    public String getSiteOfFirstMet() {
        return siteOfFirstMet;
    }

    public void setSiteOfFirstMet(String siteOfFirstMet) {
        this.siteOfFirstMet = siteOfFirstMet;
    }

    public Zrecur getZrecur() {
        return zrecur;
    }

    public void setZrecur(Zrecur zrecur) {
        this.zrecur = zrecur;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStainingVeIHC() {
        return stainingVeIHC;
    }

    public void setStainingVeIHC(String stainingVeIHC) {
        this.stainingVeIHC = stainingVeIHC;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getNodesTaken() {
        return nodesTaken;
    }

    public void setNodesTaken(String nodesTaken) {
        this.nodesTaken = nodesTaken;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Integer getPeriNeural() {
        return periNeural;
    }

    public void setPeriNeural(Integer periNeural) {
        this.periNeural = periNeural;
    }

    public Integer getLvsi() {
        return lvsi;
    }

    public void setLvsi(Integer lvsi) {
        this.lvsi = lvsi;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Zpath getZpath() {
        return zpath;
    }

    public void setZpath(Zpath zpath) {
        this.zpath = zpath;
    }

    public Integer getSizePrimaryMm() {
        return sizePrimaryMm;
    }

    public void setSizePrimaryMm(Integer sizePrimaryMm) {
        this.sizePrimaryMm = sizePrimaryMm;
    }

    public Zbx getZbx() {
        return zbx;
    }

    public void setZbx(Zbx zbx) {
        this.zbx = zbx;
    }

    public Zlocation getZlocation() {
        return zlocation;
    }

    public void setZlocation(Zlocation zlocation) {
        this.zlocation = zlocation;
    }

    public LocalDate getORDate() {
        return oRDate;
    }

    public void setORDate(LocalDate oRDate) {
        this.oRDate = oRDate;
    }

    public PtId getPtId() {
        return ptId;
    }

    public void setPtId(PtId ptId) {
        this.ptId = ptId;
    }

    public String getNodesVe() {
        return nodesVe;
    }

    public void setNodesVe(String nodesVe) {
        this.nodesVe = nodesVe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}