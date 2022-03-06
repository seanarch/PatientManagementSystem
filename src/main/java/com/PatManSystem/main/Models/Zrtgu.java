package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrtgu")
public class Zrtgu {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 100)
    private String gu;

    @OneToMany(mappedBy = "zrtgu")
    private Set<RadiationTherapy> rts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "zrtgu")
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