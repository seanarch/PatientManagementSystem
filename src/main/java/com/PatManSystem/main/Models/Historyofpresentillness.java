package com.PatManSystem.main.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "historyofpresentillness")
public class Historyofpresentillness {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Descriptor")
    private Typeofhistoryofpresentillness descriptor;


}