package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @Column(name = "`Bx ID`", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

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

}