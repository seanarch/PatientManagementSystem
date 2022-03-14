package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diagnosticimaging")
public class DiagnosticImaging {
    @Id
    @Column(name = "DI", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "DateDI")
    private LocalDate dateDI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeDI")
    private TypeOfDiagnosticImaging zdi;

    @Column(name = "Finding", length = 200)
    private String finding;

    public String getFinding() {
        return finding;
    }

    public void setFinding(String finding) {
        this.finding = finding;
    }

    public TypeOfDiagnosticImaging getTypeOfDiagnosticImaging() {
        return zdi;
    }

    public void setTypeOfDiagnosticImaging(TypeOfDiagnosticImaging zdi) {
        this.zdi = zdi;
    }

    public LocalDate getDateDI() {
        return dateDI;
    }

    public void setDateDI(LocalDate dateDI) {
        this.dateDI = dateDI;
    }

    public PtId getPtId() {
        return ptId;
    }

    public void setPtId(PtId ptId) {
        this.ptId = ptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
} 