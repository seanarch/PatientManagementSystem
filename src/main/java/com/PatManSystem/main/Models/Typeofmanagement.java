package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "typeofmanagement")
public class Typeofmanagement {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", length = 1000)
    private String description;

    @OneToMany(mappedBy = "intervention")
    private Set<Management> managements = new LinkedHashSet<>();

    public Set<Management> getManagements() {
        return managements;
    }

}