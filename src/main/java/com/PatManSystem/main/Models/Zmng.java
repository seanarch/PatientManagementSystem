package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zmng")
public class Zmng {
    @Id
    @Column(name = "`MNG ID`", nullable = false)
    private Integer id;

    @Column(name = "Managment", nullable = false, length = 50)
    private String managment;

    @OneToMany(mappedBy = "zmng")
    private Set<Mng> mngs = new LinkedHashSet<>();

    public Set<Mng> getMngs() {
        return mngs;
    }

    public void setMngs(Set<Mng> mngs) {
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