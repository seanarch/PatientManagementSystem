package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zlocation")
public class Zlocation {
    @Id
    @Column(name = "`Location ID`", nullable = false)
    private Integer id;

    @Column(name = "`Table`", nullable = false, length = 45)
    private String table;

    @OneToMany(mappedBy = "zlocation")
    private Set<Dx> dxes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "zlocation")
    private Set<Rt> rts = new LinkedHashSet<>();

    public Set<Rt> getRts() {
        return rts;
    }

    public void setRts(Set<Rt> rts) {
        this.rts = rts;
    }

    public Set<Dx> getDxes() {
        return dxes;
    }

    public void setDxes(Set<Dx> dxes) {
        this.dxes = dxes;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}