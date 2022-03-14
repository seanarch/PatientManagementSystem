package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lung")
public class Lung {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 200)
    private String ecog;

    @OneToMany(mappedBy = "lung")
    private Set<Exam> exams = new LinkedHashSet<>();

    @OneToMany(mappedBy = "lung")
    private Set<FollowUp> fus = new LinkedHashSet<>();

    public Set<FollowUp> getFus() {
        return fus;
    }

    public void setFus(Set<FollowUp> fus) {
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