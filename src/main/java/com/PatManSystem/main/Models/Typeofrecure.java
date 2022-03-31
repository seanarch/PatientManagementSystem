package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "typeofrecure")
public class Typeofrecure {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", length = 1000)
    private String description;

    @OneToMany(mappedBy = "recur")
    private Set<Diagnosis> diagnoses = new LinkedHashSet<>();

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

}