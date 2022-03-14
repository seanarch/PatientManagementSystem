package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bodylocation")
public class BodyLocation {
    @Id
    @Column(name = "`Location ID`", nullable = false)
    private Integer id;

    @Column(name = "`Table`", nullable = false, length = 45)
    private String table;

    @OneToMany(mappedBy = "bodylocation")
    private Set<Diagnosis> dxes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "bodylocation")
    private Set<RadiationTherapy> rts = new LinkedHashSet<>();

    public Set<RadiationTherapy> getRts() {
        return rts;
    }

    public void setRts(Set<RadiationTherapy> rts) {
        this.rts = rts;
    }

    public Set<Diagnosis> getDxes() {
        return dxes;
    }

    public void setDxes(Set<Diagnosis> dxes) {
        this.dxes = dxes;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 