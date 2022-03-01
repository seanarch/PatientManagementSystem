package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrthep")
public class Zrthep {
    @Id
    @Column(name = "RT", nullable = false)
    private Integer id;

    @Column(name = "Hep", nullable = false, length = 90)
    private String hep;

    @OneToMany(mappedBy = "zrthep")
    private Set<Rt> rts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "zrthep")
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

    public String getHep() {
        return hep;
    }

    public void setHep(String hep) {
        this.hep = hep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}