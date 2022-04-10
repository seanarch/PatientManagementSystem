package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bodylocation")
public class Bodylocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", length = 45)
    private String description;
}