package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "decision")
public class Decision {
    @Id
    @Column(name = "DecID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Decision")
    private TypeOfDecision zdecide;

    @Column(name = "Detail", length = 200)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public TypeOfDecision getTypeOfDecision() {
        return zdecide;
    }

    public void setTypeOfDecision(TypeOfDecision zdecide) {
        this.zdecide = zdecide;
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
