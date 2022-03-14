package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typeofbiopsy")
public class TypeOfBiopsy {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 500)
    private String bx;

    @OneToMany(mappedBy = "typeofbiopsy")
    private Set<Diagnosis> dxes = new LinkedHashSet<>();

    public Set<Diagnosis> getDxes() {
        return dxes;
    }

    public void setDxes(Set<Diagnosis> dxes) {
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