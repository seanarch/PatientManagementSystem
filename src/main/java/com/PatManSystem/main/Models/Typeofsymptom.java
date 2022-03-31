package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "typeofsymptom")
public class Typeofsymptom {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Decription", length = 100)
    private String decription;

    @OneToMany(mappedBy = "symptom")
    private Set<Symptom> symptoms = new LinkedHashSet<>();

    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

}