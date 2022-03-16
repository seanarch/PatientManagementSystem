package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "patientinformation")
public class Patientinformation {
    @Id
    @Column(name = "ULI", nullable = false)
    private Long id;

    @Column(name = "Lastname", length = 45)
    private String lastname;

    @Column(name = "Firstname", nullable = false, length = 45)
    private String firstname;

    @Column(name = "Sex", nullable = false)
    private Character sex;

    @Column(name = "Birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "Print")
    private Integer print;

    @Column(name = "TG", length = 45)
    private String tg;

    @Column(name = "Location", length = 45)
    private String location;

}