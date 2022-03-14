package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "historyofpresentillness")
public class HistoryOfPresentIllness {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Descriptor")
    private TypeOfHistoryOfPresentIllness zdescript;

    public TypeOfHistoryOfPresentIllness getTypeOfHistoryOfPresentIllness() {
        return zdescript;
    }

    public void setTypeOfHistoryOfPresentIllness(TypeOfHistoryOfPresentIllness zdescript) {
        this.zdescript = zdescript;
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