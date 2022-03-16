package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "mrcdyspnoeascale")
public class Mrcdyspnoeascale {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 60)
    private String description;

    @OneToMany(mappedBy = "breathing")
    private Set<Assess> assesses = new LinkedHashSet<>();

    public Set<Assess> getAssesses() {
        return assesses;
    }


}