package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fu")
public class Fu {
    @Id
    @Column(name = "`FU RT`", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Type FU:`")
    private Zfu zfu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Clinical Response`")
    private Zresponse zresponse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pneumonitis")
    private ZpxLung zpxLung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Upper GI`")
    private Zrtugi zrtugi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Skin Reaction`")
    private Zrtskin zrtskin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Lower GI`")
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

    public ZpxLung getZpxLung() {
        return zpxLung;
    }

    public void setZpxLung(ZpxLung zpxLung) {
        this.zpxLung = zpxLung;
    }

    public Zresponse getZresponse() {
        return zresponse;
    }

    public void setZresponse(Zresponse zresponse) {
        this.zresponse = zresponse;
    }

    public Zfu getZfu() {
        return zfu;
    }

    public void setZfu(Zfu zfu) {
        this.zfu = zfu;
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