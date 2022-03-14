package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofsymptom")
public class Typeofsymptom {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Decription", nullable = false, length = 100)
    private String decription;

    @OneToMany(mappedBy = "symptom")
    private Set<Symptom> symptoms = new LinkedHashSet<>();

    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}