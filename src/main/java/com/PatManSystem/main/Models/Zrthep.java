package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrthep")
public class Zrthep {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 100)
    private String hep;

    @OneToMany(mappedBy = "zrthep")
    private Set<RadiationTherapy> rts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "zrthep")
    private Set<FollowUp> fus = new LinkedHashSet<>();

    public Set<FollowUp> getFus() {
        return fus;
    }

    public void setFus(Set<FollowUp> fus) {
        this.fus = fus;
    }

    public Set<RadiationTherapy> getRts() {
        return rts;
    }

    public void setRts(Set<RadiationTherapy> rts) {
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
