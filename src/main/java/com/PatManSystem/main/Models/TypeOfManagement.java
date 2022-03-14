package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofmanagement")
public class TypeOfManagement {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 1000)
    private String managment;

    @OneToMany(mappedBy = "typeofmanagement")
    private Set<Management> mngs = new LinkedHashSet<>();

    public Set<Management> getMngs() {
        return mngs;
    }

    public void setMngs(Set<Management> mngs) {
        this.mngs = mngs;
    }

    public String getManagment() {
        return managment;
    }

    public void setManagment(String managment) {
        this.managment = managment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 