package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrtplan")
public class Zrtplan {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 100)
    private String plan;

    @OneToMany(mappedBy = "zrtplan")
    private Set<RadiationTherapy> rts = new LinkedHashSet<>();

    public Set<RadiationTherapy> getRts() {
        return rts;
    }

    public void setRts(Set<RadiationTherapy> rts) {
        this.rts = rts;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 