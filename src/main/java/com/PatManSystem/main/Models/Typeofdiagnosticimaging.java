package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "typeofdiagnosticimaging")
public class Typeofdiagnosticimaging {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 500)
    private String description;

    @OneToMany(mappedBy = "typeDI")
    private Set<Diagnosticimaging> diagnosticimagings = new LinkedHashSet<>();

    public Set<Diagnosticimaging> getDiagnosticimagings() {
        return diagnosticimagings;
    }

}