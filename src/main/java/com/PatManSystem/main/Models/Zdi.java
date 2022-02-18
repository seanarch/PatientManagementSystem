package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zdi")
public class Zdi {
    @Id
    @Column(name = "Field1", nullable = false)
    private Integer id;

    @Column(name = "`Type of Investigation`", nullable = false, length = 45)
    private String typeOfInvestigation;

    @OneToMany(mappedBy = "zdi")
    private Set<Di> dis = new LinkedHashSet<>();

    public Set<Di> getDis() {
        return dis;
    }

    public void setDis(Set<Di> dis) {
        this.dis = dis;
    }

    public String getTypeOfInvestigation() {
        return typeOfInvestigation;
    }

    public void setTypeOfInvestigation(String typeOfInvestigation) {
        this.typeOfInvestigation = typeOfInvestigation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}