package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "followup")
public class Followup {
    @Id
    @Column(name = "`FU RT`", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

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

}