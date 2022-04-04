package com.PatManSystem.main.Models;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Exam", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Abdo")
    private Abdomen abdo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CNS")
    private Centralnervoussystem cns;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lung")
    private Lung lung;


    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "HN")
    private Headandneck hn;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Oral")
    private Oral oral;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cardiac")
    private Cardiac cardiac;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSK")
    private Musculoskeletal msk;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Peripheral")
    private Skin peripheral;


    @Column(name = "ABNORMAL", length = 2000)
    private String abnormal;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Supine")
    private Supine supine;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Breath")
    private Breath breath;

}