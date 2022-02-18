package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zgoc")
public class Zgoc {
    @Id
    @Column(name = "`GOC ID`", nullable = false)
    private Integer id;

    @Column(name = "`GOC des`", nullable = false, length = 45)
    private String gOCDes;

    @OneToMany(mappedBy = "zgoc")
    private Set<Phx> phxes = new LinkedHashSet<>();

    public Set<Phx> getPhxes() {
        return phxes;
    }

    public void setPhxes(Set<Phx> phxes) {
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