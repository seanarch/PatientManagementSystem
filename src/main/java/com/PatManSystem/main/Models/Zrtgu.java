package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrtgu")
public class Zrtgu {
    @Id
    @Column(name = "RT", nullable = false)
    private Integer id;

    @Column(name = "GU", nullable = false, length = 90)
    private String gu;

    @OneToMany(mappedBy = "zrtgu")
    private Set<Rt> rts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "zrtgu")
    private Set<Fu> fus = new LinkedHashSet<>();

    public Set<Fu> getFus() {
        return fus;
    }

    public void setFus(Set<Fu> fus) {
        this.fus = fus;
    }

    public Set<Rt> getRts() {
        return rts;
    }

    public void setRts(Set<Rt> rts) {
        this.rts = rts;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}