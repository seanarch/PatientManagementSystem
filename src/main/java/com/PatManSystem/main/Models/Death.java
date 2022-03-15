package com.PatManSystem.main.Models;

import com.PatManSystem.main.Models.PtId;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "death")
public class Death {
    @Id
    @Column(name = "DeathID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Detail", length = 200)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
