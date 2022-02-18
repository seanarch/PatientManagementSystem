package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrtugi")
public class Zrtugi {
    @Id
    @Column(name = "RT", nullable = false)
    private Integer id;

    @Column(name = "UGI", nullable = false, length = 100)
    private String ugi;

    @OneToMany(mappedBy = "zrtugi")
    private Set<Rt> rts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "zrtugi")
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

    public String getUgi() {
        return ugi;
    }

    public void setUgi(String ugi) {
        this.ugi = ugi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}