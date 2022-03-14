package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "consider")
public class Consider {
    @Id
    @Column(name = "ConID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Consider")
    private Typeofconsideration consider;

    @Column(name = "Detail", length = 5000)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Typeofconsideration getConsider() {
        return consider;
    }

    public void setConsider(Typeofconsideration consider) {
        this.consider = consider;
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