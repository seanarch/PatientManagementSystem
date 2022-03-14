package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diagnosticimaging")
public class Diagnosticimaging {
    @Id
    @Column(name = "DI", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @Column(name = "DateDI")
    private LocalDate dateDI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeDI")
    private Typeofdiagnosticimaging typeDI;

    @Column(name = "Finding", length = 5000)
    private String finding;

    public String getFinding() {
        return finding;
    }

    public void setFinding(String finding) {
        this.finding = finding;
    }

    public Typeofdiagnosticimaging getTypeDI() {
        return typeDI;
    }

    public void setTypeDI(Typeofdiagnosticimaging typeDI) {
        this.typeDI = typeDI;
    }

    public LocalDate getDateDI() {
        return dateDI;
    }

    public void setDateDI(LocalDate dateDI) {
        this.dateDI = dateDI;
    }

    public PtId getUli() {
        return uli;
    }

    public void setUli(PtId uli) {
        this.uli = uli;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}