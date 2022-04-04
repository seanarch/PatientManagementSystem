package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "management")
public class Management {
    @Id
    @Column(name = "MNG", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Intervention")
    private Typeofmanagement intervention;

    @Column(name = "Detail", length = 5000)
    private String detail;

}