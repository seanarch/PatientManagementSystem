package com.PatManSystem.main.Models;

import com.PatManSystem.main.Models.Patientinformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "childpugh")
public class Childpugh {
    @Id
    @Column(name = "CPID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private Patientinformation uli;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "`Total Bili (umol/l)`")
    private Integer totalBiliUmolL;

    @Column(name = "`Serum Alb (g/l)`")
    private Integer serumAlbGL;

    @Column(name = "`PT INR`")
    private Double ptInr;

    @Column(name = "Ascites", length = 45)
    private String ascites;

    @Column(name = "`Hepatic Ench`", length = 45)
    private String hepaticEnch;

    @Column(name = "`Child Pugh Score`")
    private Integer childPughScore;

    @Column(name = "`Child Pugh`", length = 1)
    private String childPugh;
}