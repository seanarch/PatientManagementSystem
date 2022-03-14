package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    public void setDiagnosticimagings(Set<Diagnosticimaging> diagnosticimagings) {
        this.diagnosticimagings = diagnosticimagings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}