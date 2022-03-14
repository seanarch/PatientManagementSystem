package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zfu")
public class Zfu {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 1000)
    private String description;

    @OneToMany(mappedBy = "typeFU")
    private Set<Followup> followups = new LinkedHashSet<>();

    public Set<Followup> getFollowups() {
        return followups;
    }

    public void setFollowups(Set<Followup> followups) {
        this.followups = followups;
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