package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @Column(name = "`Bx ID`", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @Column(name = "`Nodes +ve`", length = 100)
    private String nodesVe;

    @Column(name = "`OR Date`")
    private LocalDate oRDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Location")
    private Bodylocation location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`OR`")
    private Typeofbiopsy or;

    @Column(name = "`Size Primary (mm)`")
    private Integer sizePrimaryMm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pathology")
    private Typeofpathology pathology;

    @Column(name = "Grade", length = 100)
    private String grade;

    @Column(name = "Margin", length = 200)
    private String margin;

    @Column(name = "LVSI")
    private Integer lvsi;

    @Column(name = "`Peri Neural`")
    private Integer periNeural;

    @Column(name = "T", length = 100)
    private String t;

    @Column(name = "`Nodes Taken`", length = 100)
    private String nodesTaken;

    @Column(name = "N", length = 100)
    private String n;

    @Column(name = "M", length = 100)
    private String m;

    @Column(name = "`Staining +ve IHC`", length = 200)
    private String stainingVeIHC;

    @Column(name = "Stage", length = 100)
    private String stage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Recur")
    private Typeofrecure recur;

    @Column(name = "`Site of First Met`", length = 500)
    private String siteOfFirstMet;

    @Column(name = "Today")
    private LocalDate today;

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public String getSiteOfFirstMet() {
        return siteOfFirstMet;
    }

    public void setSiteOfFirstMet(String siteOfFirstMet) {
        this.siteOfFirstMet = siteOfFirstMet;
    }

    public Typeofrecure getRecur() {
        return recur;
    }

    public void setRecur(Typeofrecure recur) {
        this.recur = recur;
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

    public Typeofpathology getPathology() {
        return pathology;
    }

    public void setPathology(Typeofpathology pathology) {
        this.pathology = pathology;
    }

    public Integer getSizePrimaryMm() {
        return sizePrimaryMm;
    }

    public void setSizePrimaryMm(Integer sizePrimaryMm) {
        this.sizePrimaryMm = sizePrimaryMm;
    }

    public Typeofbiopsy getOr() {
        return or;
    }

    public void setOr(Typeofbiopsy or) {
        this.or = or;
    }

    public Bodylocation getLocation() {
        return location;
    }

    public void setLocation(Bodylocation location) {
        this.location = location;
    }

    public LocalDate getORDate() {
        return oRDate;
    }

    public void setORDate(LocalDate oRDate) {
        this.oRDate = oRDate;
    }

    public String getNodesVe() {
        return nodesVe;
    }

    public void setNodesVe(String nodesVe) {
        this.nodesVe = nodesVe;
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