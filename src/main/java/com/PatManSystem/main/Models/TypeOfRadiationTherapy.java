package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofradiationtherapy")
public class TypeOfRadiationTherapy {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 500)
    private String typeRT;

    @OneToMany(mappedBy = "typeofradiationtherapy")
    private Set<RadiationTherapy> rts = new LinkedHashSet<>();

    public Set<RadiationTherapy> getRts() {
        return rts;
    }

    public void setRts(Set<RadiationTherapy> rts) {
        this.rts = rts;
    }

    public String getTypeRT() {
        return typeRT;
    }

    public void setTypeRT(String typeRT) {
        this.typeRT = typeRT;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 