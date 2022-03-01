package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "pmhx")
public class Pmhx {
    @Id
    @Column(name = "PMhx", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId ptId;

    @Column(name = "Dx", length = 200)
    private String dx;

    @Column(name = "Gen_Dx", length = 1)
    private String genDx;

    public String getGenDx() {
        return genDx;
    }

    public void setGenDx(String genDx) {
        this.genDx = genDx;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
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