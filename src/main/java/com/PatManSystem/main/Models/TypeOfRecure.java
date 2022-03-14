package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofrecure")
public class TypeOfRecure {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 10)
    private String zRecur;

    @OneToMany(mappedBy = "typeofrecure")
    private Set<Diagnosis> dxes = new LinkedHashSet<>();

    public Set<Diagnosis> getDxes() {
        return dxes;
    }

    public void setDxes(Set<Diagnosis> dxes) {
        this.dxes = dxes;
    }

    public String getZRecur() {
        return zRecur;
    }

    public void setZRecur(String zRecur) {
        this.zRecur = zRecur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 