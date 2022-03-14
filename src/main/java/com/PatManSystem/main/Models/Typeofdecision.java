package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofdecision")
public class Typeofdecision {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 1000)
    private String description;

    @OneToMany(mappedBy = "decision")
    private Set<Decision> decisions = new LinkedHashSet<>();

    public Set<Decision> getDecisions() {
        return decisions;
    }

    public void setDecisions(Set<Decision> decisions) {
        this.decisions = decisions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}