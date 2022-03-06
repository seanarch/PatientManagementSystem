package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "symptom")
public class Symptom {
    @Id
    @Column(name = "SxID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Symptom")
    private TypeOfSymptom zsx;

    @Column(name = "Detail", length = 100)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public TypeOfSymptom getTypeOfSymptom() {
        return zsx;
    }

    public void setTypeOfSymptom(TypeOfSymptom zsx) {
        this.zsx = zsx;
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