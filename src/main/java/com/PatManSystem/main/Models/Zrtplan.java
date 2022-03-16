package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
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

}