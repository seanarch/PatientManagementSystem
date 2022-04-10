package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "consider")
public class Consider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Consider")
    private Typeofconsideration consider;

    @Column(name = "Detail", length = 5000)
    private String detail;

}