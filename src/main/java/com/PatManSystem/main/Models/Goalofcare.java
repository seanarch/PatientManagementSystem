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
@Table(name = "goalofcare")
public class Goalofcare {
    @Id
    @Column(name = "TypeID", nullable = false)
    private Integer id;

}