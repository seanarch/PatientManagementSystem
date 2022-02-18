package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zconsider")
public class Zconsider {
    @Id
    @Column(name = "`Consider ID`", nullable = false)
    private Integer id;

    @Column(name = "ConsID", nullable = false, length = 100)
    private String consID;

    @OneToMany(mappedBy = "zconsider")
    private Set<Consider> considers = new LinkedHashSet<>();

    public Set<Consider> getConsiders() {
        return considers;
    }

    public void setConsiders(Set<Consider> considers) {
        this.considers = considers;
    }

    public String getConsID() {
        return consID;
    }

    public void setConsID(String consID) {
        this.consID = consID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}