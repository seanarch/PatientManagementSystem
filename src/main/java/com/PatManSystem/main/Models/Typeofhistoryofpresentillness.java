package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofhistoryofpresentillness")
public class Typeofhistoryofpresentillness {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 1000)
    private String description;

    @OneToMany(mappedBy = "descriptor")
    private Set<Historyofpresentillness> historyofpresentillnesses = new LinkedHashSet<>();

    public Set<Historyofpresentillness> getHistoryofpresentillnesses() {
        return historyofpresentillnesses;
    }

    public void setHistoryofpresentillnesses(Set<Historyofpresentillness> historyofpresentillnesses) {
        this.historyofpresentillnesses = historyofpresentillnesses;
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