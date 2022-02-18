package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zrtskin")
public class Zrtskin {
    @Id
    @Column(name = "Skin", nullable = false)
    private Integer id;

    @Column(name = "RTOG", nullable = false, length = 100)
    private String rtog;

    @OneToMany(mappedBy = "zrtskin")
    private Set<Rt> rts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "zrtskin")
    private Set<Fu> fus = new LinkedHashSet<>();

    public Set<Fu> getFus() {
        return fus;
    }

    public void setFus(Set<Fu> fus) {
        this.fus = fus;
    }

    public Set<Rt> getRts() {
        return rts;
    }

    public void setRts(Set<Rt> rts) {
        this.rts = rts;
    }

    public String getRtog() {
        return rtog;
    }

    public void setRtog(String rtog) {
        this.rtog = rtog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}