package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zbx")
public class Zbx {
    @Id
    @Column(name = "`Bx ID`", nullable = false)
    private Integer id;

    @Column(name = "BX", nullable = false, length = 45)
    private String bx;

    @OneToMany(mappedBy = "zbx")
    private Set<Dx> dxes = new LinkedHashSet<>();

    public Set<Dx> getDxes() {
        return dxes;
    }

    public void setDxes(Set<Dx> dxes) {
        this.dxes = dxes;
    }

    public String getBx() {
        return bx;
    }

    public void setBx(String bx) {
        this.bx = bx;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}