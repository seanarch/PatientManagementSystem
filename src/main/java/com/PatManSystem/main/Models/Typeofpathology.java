package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "typeofpathology")
public class Typeofpathology {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 500)
    private String description;

    @OneToMany(mappedBy = "pathology")
    private Set<Diagnosis> diagnoses = new LinkedHashSet<>();

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

}