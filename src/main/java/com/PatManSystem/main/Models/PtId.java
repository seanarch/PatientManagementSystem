package com.PatManSystem.main.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "`_pt id`")
public class PtId {
    @Id
    @Column(name = "ULI", nullable = false)
    private Integer id;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public Integer getPrint() {
        return print;
    }

    public void setPrint(Integer print) {
        this.print = print;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}