package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "radiationtherapy")
public class Radiationtherapy {
    @Id
    @Column(name = "RT", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @Column(name = "DateRTStart")
    private LocalDate dateRTStart;

    @Column(name = "DateRTEnd")
    private LocalDate dateRTEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeRT")
    private Typeofradiationtherapy typeRT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Location")
    private Bodylocation location;

    @Column(name = "RTDose")
    private Double rTDose;

    @Column(name = "Fraction")
    private Integer fraction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Planning")
    private Zrtplan planning;

    @Column(name = "AnatDetail", length = 1000)
    private String anatDetail;

    @Column(name = "General", length = 1000)
    private String general;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pneumonitis")
    private Zrtlung pneumonitis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UpperGI")
    private Zrtugi upperGI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SkinReaction")
    private Zrtskin skinReaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LowerGI")
    private Zrtlgi lowerGI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GU")
    private Zrtgu gu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Heme")
    private Zrtheme heme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Hepatic")
    private Zrthep hepatic;

    @Column(name = "`Other Toxicity`", length = 500)
    private String otherToxicity;

    @Column(name = "`Other Toxicity Detail`", length = 500)
    private String otherToxicityDetail;

    @Column(name = "Details", length = 500)
    private String details;

    @Column(name = "NG")
    private Integer ng;

    public Integer getNg() {
        return ng;
    }

    public void setNg(Integer ng) {
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

    public Zrthep getHepatic() {
        return hepatic;
    }

    public void setHepatic(Zrthep hepatic) {
        this.hepatic = hepatic;
    }

    public Zrtheme getHeme() {
        return heme;
    }

    public void setHeme(Zrtheme heme) {
        this.heme = heme;
    }

    public Zrtgu getGu() {
        return gu;
    }

    public void setGu(Zrtgu gu) {
        this.gu = gu;
    }

    public Zrtlgi getLowerGI() {
        return lowerGI;
    }

    public void setLowerGI(Zrtlgi lowerGI) {
        this.lowerGI = lowerGI;
    }

    public Zrtskin getSkinReaction() {
        return skinReaction;
    }

    public void setSkinReaction(Zrtskin skinReaction) {
        this.skinReaction = skinReaction;
    }

    public Zrtugi getUpperGI() {
        return upperGI;
    }

    public void setUpperGI(Zrtugi upperGI) {
        this.upperGI = upperGI;
    }

    public Zrtlung getPneumonitis() {
        return pneumonitis;
    }

    public void setPneumonitis(Zrtlung pneumonitis) {
        this.pneumonitis = pneumonitis;
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

    public Zrtplan getPlanning() {
        return planning;
    }

    public void setPlanning(Zrtplan planning) {
        this.planning = planning;
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

    public Bodylocation getLocation() {
        return location;
    }

    public void setLocation(Bodylocation location) {
        this.location = location;
    }

    public Typeofradiationtherapy getTypeRT() {
        return typeRT;
    }

    public void setTypeRT(Typeofradiationtherapy typeRT) {
        this.typeRT = typeRT;
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