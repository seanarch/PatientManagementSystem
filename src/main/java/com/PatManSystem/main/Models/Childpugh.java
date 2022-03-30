package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "childpugh")
public class Childpugh {
    @Id
    @Column(name = "CPID", nullable = false)
    private Integer id;

}