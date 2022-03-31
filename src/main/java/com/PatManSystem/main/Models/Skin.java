package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "skin")
public class Skin {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", length = 200)
    private String description;

    @OneToMany(mappedBy = "peripheral")
    private Set<Exam> exams = new LinkedHashSet<>();

    public Set<Exam> getExams() {
        return exams;
    }

}