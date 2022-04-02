package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "radiationtherapy")


public class Radiationtherapy {
    @Id
    @Column(name = "RT", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "Datertstart")
    private LocalDate dateRTStart;

    @Column(name = "DateRTEnd")
    private LocalDate dateRTEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Typert")
    private Typeofradiationtherapy typeRT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Location")
    private Bodylocation location;

    @Column(name = "Rtdose")
    private Double rTDose;

    @Column(name = "Fraction")
    private Integer fraction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Planning")
    private Zrtplan planning;

    @Column(name = "Anatdetail", length = 1000)
    private String anatDetail;

    @Column(name = "General", length = 1000)
    private String general;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pneumonitis")
    private Zrtlung pneumonitis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Uppergi")
    private Zrtugi upperGI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Skinreaction")
    private Zrtskin skinReaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lowergi")
    private Zrtlgi lowerGI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Gu")
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

}