package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "zrtlgi")
public class Zrtlgi {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 100)
    private String description;

    @OneToMany(mappedBy = "lowerGI")
    private Set<Radiationtherapy> radiationtherapies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "lowerGI")
    private Set<Followup> followups = new LinkedHashSet<>();

    public Set<Followup> getFollowups() {
        return followups;
    }

    public void setFollowups(Set<Followup> followups) {
        this.followups = followups;
    }

    public Set<Radiationtherapy> getRadiationtherapies() {
        return radiationtherapies;
    }

    public void setRadiationtherapies(Set<Radiationtherapy> radiationtherapies) {
        this.radiationtherapies = radiationtherapies;
    }


}