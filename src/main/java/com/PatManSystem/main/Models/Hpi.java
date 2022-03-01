package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "hpi")
public class Hpi {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Descriptor")
    private Zdescript zdescript;

    public Zdescript getZdescript() {
        return zdescript;
    }

    public void setZdescript(Zdescript zdescript) {
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