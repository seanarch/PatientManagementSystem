package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "mellowscore")
public class MellowScore {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 60)
    private String mellowScore;

    @OneToMany(mappedBy = "mellowscore")
    private Set<Assess> assesses = new LinkedHashSet<>();

    public Set<Assess> getAssesses() {
        return assesses;
    }

    public void setAssesses(Set<Assess> assesses) {
        this.assesses = assesses;
    }

    public String getMellowScore() {
        return mellowScore;
    }

    public void setMellowScore(String mellowScore) {
        this.mellowScore = mellowScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 