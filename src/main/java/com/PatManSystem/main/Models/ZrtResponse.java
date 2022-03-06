package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrtresponse")
public class ZrtResponse {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 500)
    private String response;

    @OneToMany(mappedBy = "zrtresponse")
    private Set<FollowUp> fus = new LinkedHashSet<>();

    public Set<FollowUp> getFus() {
        return fus;
    }

    public void setFus(Set<FollowUp> fus) {
        this.fus = fus;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 