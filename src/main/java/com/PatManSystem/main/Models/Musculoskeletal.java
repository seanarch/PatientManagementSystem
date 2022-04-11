package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "musculoskeletal")
public class Musculoskeletal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "Description", length = 200)
    private String description;
}