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
    private PtId uli;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Decision")
    private Typeofdecision decision;

    @Column(name = "Detail", length = 5000)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Typeofdecision getDecision() {
        return decision;
    }

    public void setDecision(Typeofdecision decision) {
        this.decision = decision;
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