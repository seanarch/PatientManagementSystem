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
    private PtId ptId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Consider")
    private Zconsider zconsider;

    @Column(name = "Detail", length = 200)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Zconsider getZconsider() {
        return zconsider;
    }

    public void setZconsider(Zconsider zconsider) {
        this.zconsider = zconsider;
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