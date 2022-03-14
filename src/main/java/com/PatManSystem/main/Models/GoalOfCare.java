package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "goalofcare")
public class GoalOfCare {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 45)
    private String gOCDes;

    @OneToMany(mappedBy = "goalofcare")
    private Set<PastHistory> phxes = new LinkedHashSet<>();

    public Set<PastHistory> getPhxes() {
        return phxes;
    }

    public void setPhxes(Set<PastHistory> phxes) {
        this.phxes = phxes;
    }

    public String getGOCDes() {
        return gOCDes;
    }

    public void setGOCDes(String gOCDes) {
        this.gOCDes = gOCDes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

} 