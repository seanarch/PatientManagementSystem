package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "followup")
public class Followup {
    @Id
    @Column(name = "`FU RT`", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Type FU`")
    private Zfu typeFU;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Clinical Response`")
    private Zrtresponse clinicalResponse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pneumonitis")
    private Zrtlung pneumonitis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Upper GI`")
    private Zrtugi upperGI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Skin Reaction`")
    private Zrtskin skinReaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Lower GI`")
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

    @Column(name = "`Other Toxicity`", length = 45)
    private String otherToxicity;

    @Column(name = "`Other Tox Detail`", length = 45)
    private String otherToxDetail;

    public String getOtherToxDetail() {
        return otherToxDetail;
    }

    public void setOtherToxDetail(String otherToxDetail) {
        this.otherToxDetail = otherToxDetail;
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

    public Zrtresponse getClinicalResponse() {
        return clinicalResponse;
    }

    public void setClinicalResponse(Zrtresponse clinicalResponse) {
        this.clinicalResponse = clinicalResponse;
    }

    public Zfu getTypeFU() {
        return typeFU;
    }

    public void setTypeFU(Zfu typeFU) {
        this.typeFU = typeFU;
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