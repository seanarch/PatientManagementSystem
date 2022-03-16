package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "pulmonaryfunctiontests")
public class Pulmonaryfunctiontest {
    @Id
    @Column(name = "PFT", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "FVC")
    private Double fvc;

    @Column(name = "`FVC%`")
    private Integer fvc1;

    @Column(name = "FEV1")
    private Double fev1;

    @Column(name = "`FEV1%`")
    private Integer fev11;

    @Column(name = "Ratio")
    private Integer ratio;

    @Column(name = "DLCO")
    private Integer dlco;

}