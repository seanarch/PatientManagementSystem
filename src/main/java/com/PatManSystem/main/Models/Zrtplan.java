package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrtplan")
public class Zrtplan {
    @Id
    @Column(name = "RT", nullable = false)
    private Integer id;

    @Column(name = "Plan", nullable = false, length = 45)
    private String plan;

    @OneToMany(mappedBy = "zrtplan")
    private Set<Rt> rts = new LinkedHashSet<>();

    public Set<Rt> getRts() {
        return rts;
    }

    public void setRts(Set<Rt> rts) {
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