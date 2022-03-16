package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "typeofradiationtherapy")
public class Typeofradiationtherapy {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 500)
    private String description;

    @OneToMany(mappedBy = "typeRT")
    private Set<Radiationtherapy> radiationtherapies = new LinkedHashSet<>();

    public Set<Radiationtherapy> getRadiationtherapies() {
        return radiationtherapies;
    }


}