package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zpx-lung")
public class ZpxLung {
    @Id
    @Column(name = "`ECOG ID`", nullable = false)
    private Integer id;

    @Column(name = "ECOG", nullable = false, length = 77)
    private String ecog;

    @OneToMany(mappedBy = "zpxLung")
    private Set<Exam> exams = new LinkedHashSet<>();

    @OneToMany(mappedBy = "zpxLung")
    private Set<Fu> fus = new LinkedHashSet<>();

    public Set<Fu> getFus() {
        return fus;
    }

    public void setFus(Set<Fu> fus) {
        this.fus = fus;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    public String getEcog() {
        return ecog;
    }

    public void setEcog(String ecog) {
        this.ecog = ecog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}