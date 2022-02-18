package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrtlung")
public class Zrtlung {
    @Id
    @Column(name = "RT", nullable = false)
    private Integer id;

    @Column(name = "Lung", nullable = false, length = 100)
    private String lung;

    @OneToMany(mappedBy = "zrtlung")
    private Set<Rt> rts = new LinkedHashSet<>();

    public Set<Rt> getRts() {
        return rts;
    }

    public void setRts(Set<Rt> rts) {
        this.rts = rts;
    }

    public String getLung() {
        return lung;
    }

    public void setLung(String lung) {
        this.lung = lung;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}