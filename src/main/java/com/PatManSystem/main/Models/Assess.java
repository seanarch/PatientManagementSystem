package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "assess")
public class Assess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WtID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ECOG")
    private Ecogperformancestatusscale ecog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Swallowing")
    private Mellowscore swallowing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Breathing")
    private Mrcdyspnoeascale breathing;

}