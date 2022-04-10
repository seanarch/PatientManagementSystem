package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "diagnosticimaging")
public class Diagnosticimaging {
    @Id
    @Column(name = "DI", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "DateDI")
    private LocalDate dateDI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeDI")
    private Typeofdiagnosticimaging typeDI;

    @Column(name = "Finding", length = 5000)
    private String finding;
}