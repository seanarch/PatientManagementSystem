package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrecur")
public class Zrecur {
    @Id
    @Column(name = "`Recur ID`", nullable = false)
    private Integer id;

    @Column(name = "zRecur", nullable = false, length = 10)
    private String zRecur;

    @OneToMany(mappedBy = "zrecur")
    private Set<Dx> dxes = new LinkedHashSet<>();

    public Set<Dx> getDxes() {
        return dxes;
    }

    public void setDxes(Set<Dx> dxes) {
        this.dxes = dxes;
    }

    public String getZRecur() {
        return zRecur;
    }

    public void setZRecur(String zRecur) {
        this.zRecur = zRecur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}