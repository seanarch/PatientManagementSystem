package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "management")
public class Management {
    @Id
    @Column(name = "MNG", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Intervention")
    private TypeOfManagement zmng;

    @Column(name = "Detail", length = 100)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public TypeOfManagement getTypeOfManagement() {
        return zmng;
    }

    public void setTypeOfManagement(TypeOfManagement zmng) {
        this.zmng = zmng;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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