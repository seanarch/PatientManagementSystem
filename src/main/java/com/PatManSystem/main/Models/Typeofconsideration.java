package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    public void setConsiders(Set<Consider> considers) {
        this.considers = considers;
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