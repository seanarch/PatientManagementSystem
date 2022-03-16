package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "typeofconsideration")
public class Typeofconsideration {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 1000)
    private String description;

    @OneToMany(mappedBy = "consider")
    private Set<Consider> considers = new LinkedHashSet<>();

    public Set<Consider> getConsiders() {
        return considers;
    }

}