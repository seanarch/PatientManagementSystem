package com.PatManSystem.main.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "patientinformation")
@NoArgsConstructor
public class Patientinformation {
    @Id
    @Column(name = "ULI", nullable = false)
    private Long id;

    @Column(name = "Lastname", length = 45)
    private String lastname;

    @Column(name = "Firstname", length = 45)
    private String firstname;

    @Column(name = "Sex")
    private Character sex;

    @Column(name = "Birthday")
    private LocalDate birthday;

    @Column(name = "Print")
    private Integer print;

    @Column(name = "TG", length = 45)
    private String tg;

    @Column(name = "Location", length = 45)
    private String location;

    public Patientinformation(Long id){
        this.id = id;
    }
}