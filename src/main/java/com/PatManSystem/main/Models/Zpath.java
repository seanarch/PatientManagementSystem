package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zpath")
public class Zpath {
    @Id
    @Column(name = "`Path ID`", nullable = false)
    private Integer id;

    @Column(name = "Pathology", nullable = false, length = 40)
    private String pathology;

    @OneToMany(mappedBy = "zpath")
    private Set<Dx> dxes = new LinkedHashSet<>();

    public Set<Dx> getDxes() {
        return dxes;
    }

    public void setDxes(Set<Dx> dxes) {
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