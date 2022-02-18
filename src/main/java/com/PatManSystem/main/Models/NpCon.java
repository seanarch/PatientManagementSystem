package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "`np cons`")
public class NpCon {
    @Id
    @Column(name = "`Bx ID`", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "`New Consult`")
    private LocalDate newConsult;

    public LocalDate getNewConsult() {
        return newConsult;
    }

    public void setNewConsult(LocalDate newConsult) {
        this.newConsult = newConsult;
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