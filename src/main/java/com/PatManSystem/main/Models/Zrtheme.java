package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrtheme")
public class Zrtheme {
    @Id
    @Column(name = "Chemo", nullable = false)
    private Integer id;

    @Column(name = "`Chemo Tox`", nullable = false, length = 60)
    private String chemoTox;

    @OneToMany(mappedBy = "zrtheme")
    private Set<Rt> rts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "zrtheme")
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

    public String getChemoTox() {
        return chemoTox;
    }

    public void setChemoTox(String chemoTox) {
        this.chemoTox = chemoTox;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}