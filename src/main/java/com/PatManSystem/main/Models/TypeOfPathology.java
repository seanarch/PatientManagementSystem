package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofpathology")
public class TypeOfPathology {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 500)
    private String pathology;

    @OneToMany(mappedBy = "typeofpathology")
    private Set<Diagnosis> dxes = new LinkedHashSet<>();

    public Set<Diagnosis> getDxes() {
        return dxes;
    }

    public void setDxes(Set<Diagnosis> dxes) {
        this.dxes = dxes;
    }

    public String getPathology() {
        return pathology;
    }

    public void setPathology(String pathology) {
        this.pathology = pathology;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 