package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ecogperformancestatusscale")
public class ECOGPerformanceStatusScale {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 100)
    private String ecog;

    @OneToMany(mappedBy = "ecogperformancestatusscale")
    private Set<Assess> assesses = new LinkedHashSet<>();

    public Set<Assess> getAssesses() {
        return assesses;
    }

    public void setAssesses(Set<Assess> assesses) {
        this.assesses = assesses;
    }

    public String getEcog() {
        return ecog;
    }

    public void setEcog(String ecog) {
        this.ecog = ecog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 