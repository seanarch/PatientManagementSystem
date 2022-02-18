package com.PatManSystem.main.Models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zpx-hn")
public class ZpxHn {
    @Id
    @Column(name = "`ECOG ID`", nullable = false)
    private Integer id;

    @Column(name = "ECOG", nullable = false, length = 79)
    private String ecog;

    @OneToMany(mappedBy = "zpxHn")
    private Set<Exam> exams = new LinkedHashSet<>();

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