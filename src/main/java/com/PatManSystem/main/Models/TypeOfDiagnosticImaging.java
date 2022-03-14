package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofdiagnosticimaging")
public class TypeOfDiagnosticImaging {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 500)
    private String typeOfInvestigation;

    @OneToMany(mappedBy = "typeofdiagnosticimaging")
    private Set<DiagnosticImaging> dis = new LinkedHashSet<>();

    public Set<DiagnosticImaging> getDis() {
        return dis;
    }

    public void setDis(Set<DiagnosticImaging> dis) {
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