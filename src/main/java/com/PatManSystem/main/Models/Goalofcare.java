package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "goalofcare")
public class Goalofcare {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 45)
    private String description;

    @OneToMany(mappedBy = "goalofcare")
    private Set<Pasthistory> pasthistories = new LinkedHashSet<>();

    public Set<Pasthistory> getPasthistories() {
        return pasthistories;
    }

    public void setPasthistories(Set<Pasthistory> pasthistories) {
        this.pasthistories = pasthistories;
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