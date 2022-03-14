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
    private String description;

    @OneToMany(mappedBy = "planning")
    private Set<Radiationtherapy> radiationtherapies = new LinkedHashSet<>();

    public Set<Radiationtherapy> getRadiationtherapies() {
        return radiationtherapies;
    }

    public void setRadiationtherapies(Set<Radiationtherapy> radiationtherapies) {
        this.radiationtherapies = radiationtherapies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}