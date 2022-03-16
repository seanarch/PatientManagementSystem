package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "pastmedicalhistory")
public class Pastmedicalhistory {
    @Id
    @Column(name = "PMhx", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "Dx", length = 8000)
    private String dx;

    @Column(name = "Gen_Dx", length = 1)
    private String genDx;

}