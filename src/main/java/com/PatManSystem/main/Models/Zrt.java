package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrt")
public class Zrt {
    @Id
    @Column(name = "RT", nullable = false)
    private Integer id;

    @Column(name = "`Type RT`", nullable = false, length = 45)
    private String typeRT;

    @OneToMany(mappedBy = "zrt")
    private Set<Rt> rts = new LinkedHashSet<>();

    public Set<Rt> getRts() {
        return rts;
    }

    public void setRts(Set<Rt> rts) {
        this.rts = rts;
    }

    public String getTypeRT() {
        return typeRT;
    }

    public void setTypeRT(String typeRT) {
        this.typeRT = typeRT;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}