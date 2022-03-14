package com.PatManSystem.main.Models;

import com.PatManSystem.main.Models.PtId;

import javax.persistence.*;

@Entity
@Table(name = "pastmedicalhistory")
public class Pastmedicalhistory {
    @Id
    @Column(name = "PMhx", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @Column(name = "Dx", length = 8000)
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