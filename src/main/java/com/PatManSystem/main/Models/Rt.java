package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rt", indexes = {
        @Index(name = "GU_fk_idx", columnList = "GU")
})
public class Rt {
    @Id
    @Column(name = "RT", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "DateRTStart")
    private LocalDate dateRTStart;

    @Column(name = "DateRTEnd")
    private LocalDate dateRTEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeRT")
    private Zrt zrt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Location")
    private Zlocation zlocation;

    @Column(name = "RTDose")
    private Double rTDose;

    @Column(name = "Fraction")
    private Integer fraction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Planning")
    private Zrtplan zrtplan;

    @Column(name = "AnatDetail", length = 45)
    private String anatDetail;

    @Column(name = "General", length = 45)
    private String general;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pneumonitis")
    private Zrtlung zrtlung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UpperGI")
    private Zrtugi zrtugi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SkinReaction")
    private Zrtskin zrtskin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LowerGI")
    private Zrtlgi zrtlgi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GU")
    private Zrtgu zrtgu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Heme")
    private Zrtheme zrtheme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Hepatic")
    private Zrthep zrthep;

    @Column(name = "`Other Toxicity`", length = 100)
    private String otherToxicity;

    @Column(name = "`Other Toxicity Detail`", length = 100)
    private String otherToxicityDetail;

    @Column(name = "Details", length = 200)
    private String details;

    @Column(name = "NG", length = 45)
    private String ng;

    public String getNg() {
        return ng;
    }

    public void setNg(String ng) {
        this.ng = ng;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOtherToxicityDetail() {
        return otherToxicityDetail;
    }

    public void setOtherToxicityDetail(String otherToxicityDetail) {
        this.otherToxicityDetail = otherToxicityDetail;
    }

    public String getOtherToxicity() {
        return otherToxicity;
    }

    public void setOtherToxicity(String otherToxicity) {
        this.otherToxicity = otherToxicity;
    }

    public Zrthep getZrthep() {
        return zrthep;
    }

    public void setZrthep(Zrthep zrthep) {
        this.zrthep = zrthep;
    }

    public Zrtheme getZrtheme() {
        return zrtheme;
    }

    public void setZrtheme(Zrtheme zrtheme) {
        this.zrtheme = zrtheme;
    }

    public Zrtgu getZrtgu() {
        return zrtgu;
    }

    public void setZrtgu(Zrtgu zrtgu) {
        this.zrtgu = zrtgu;
    }

    public Zrtlgi getZrtlgi() {
        return zrtlgi;
    }

    public void setZrtlgi(Zrtlgi zrtlgi) {
        this.zrtlgi = zrtlgi;
    }

    public Zrtskin getZrtskin() {
        return zrtskin;
    }

    public void setZrtskin(Zrtskin zrtskin) {
        this.zrtskin = zrtskin;
    }

    public Zrtugi getZrtugi() {
        return zrtugi;
    }

    public void setZrtugi(Zrtugi zrtugi) {
        this.zrtugi = zrtugi;
    }

    public Zrtlung getZrtlung() {
        return zrtlung;
    }

    public void setZrtlung(Zrtlung zrtlung) {
        this.zrtlung = zrtlung;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getAnatDetail() {
        return anatDetail;
    }

    public void setAnatDetail(String anatDetail) {
        this.anatDetail = anatDetail;
    }

    public Zrtplan getZrtplan() {
        return zrtplan;
    }

    public void setZrtplan(Zrtplan zrtplan) {
        this.zrtplan = zrtplan;
    }

    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

    public Double getRTDose() {
        return rTDose;
    }

    public void setRTDose(Double rTDose) {
        this.rTDose = rTDose;
    }

    public Zlocation getZlocation() {
        return zlocation;
    }

    public void setZlocation(Zlocation zlocation) {
        this.zlocation = zlocation;
    }

    public Zrt getZrt() {
        return zrt;
    }

    public void setZrt(Zrt zrt) {
        this.zrt = zrt;
    }

    public LocalDate getDateRTEnd() {
        return dateRTEnd;
    }

    public void setDateRTEnd(LocalDate dateRTEnd) {
        this.dateRTEnd = dateRTEnd;
    }

    public LocalDate getDateRTStart() {
        return dateRTStart;
    }

    public void setDateRTStart(LocalDate dateRTStart) {
        this.dateRTStart = dateRTStart;
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