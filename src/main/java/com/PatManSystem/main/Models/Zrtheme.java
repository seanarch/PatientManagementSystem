package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "zrtheme")
public class Zrtheme {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", length = 100)
    private String description;

    @OneToMany(mappedBy = "heme")
    private Set<Radiationtherapy> radiationtherapies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "heme")
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