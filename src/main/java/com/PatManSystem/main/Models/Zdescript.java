package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zdescript")
public class Zdescript {
    @Id
    @Column(name = "`Descript ID`", nullable = false)
    private Integer id;

    @Column(name = "ID", nullable = false, length = 40)
    private String id2;

    @OneToMany(mappedBy = "zdescript")
    private Set<Hpi> hpis = new LinkedHashSet<>();

    public Set<Hpi> getHpis() {
        return hpis;
    }

    public void setHpis(Set<Hpi> hpis) {
        this.hpis = hpis;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}