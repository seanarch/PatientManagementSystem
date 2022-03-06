package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofhistoryofpresentillness")
public class TypeOfHistoryOfPresentIllness {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 1000)
    private String id2;

    @OneToMany(mappedBy = "typeofhistoryofpresentillness")
    private Set<HistoryOfPresentIllness> hpis = new LinkedHashSet<>();

    public Set<HistoryOfPresentIllness> getHpis() {
        return hpis;
    }

    public void setHpis(Set<HistoryOfPresentIllness> hpis) {
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