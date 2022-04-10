package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "decision")
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DecID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Decision")
    private Typeofdecision decision;

    @Column(name = "Detail", length = 5000)
    private String detail;


}