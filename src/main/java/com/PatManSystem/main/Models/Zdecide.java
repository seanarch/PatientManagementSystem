package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zdecide")
public class Zdecide {
    @Id
    @Column(name = "`Decide ID`", nullable = false)
    private Integer id;

    @Column(name = "ConsID", nullable = false, length = 100)
    private String consID;

    @OneToMany(mappedBy = "zdecide")
    private Set<Decision> decisions = new LinkedHashSet<>();

    public Set<Decision> getDecisions() {
        return decisions;
    }

    public void setDecisions(Set<Decision> decisions) {
        this.decisions = decisions;
    }

    public String getConsID() {
        return consID;
    }

    public void setConsID(String consID) {
        this.consID = consID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}