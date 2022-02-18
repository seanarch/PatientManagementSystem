package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zsx")
public class Zsx {
    @Id
    @Column(name = "`Sx ID`", nullable = false)
    private Integer id;

    @Column(name = "Sx", nullable = false, length = 40)
    private String sx;

    @OneToMany(mappedBy = "zsx")
    private Set<Symptom> symptoms = new LinkedHashSet<>();

    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}