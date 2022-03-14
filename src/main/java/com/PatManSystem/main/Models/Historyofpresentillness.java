package com.PatManSystem.main.Models;

import javax.persistence.*;

@Entity
@Table(name = "historyofpresentillness")
public class Historyofpresentillness {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ULI", nullable = false)
    private PtId uli;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Descriptor")
    private Typeofhistoryofpresentillness descriptor;

    public Typeofhistoryofpresentillness getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Typeofhistoryofpresentillness descriptor) {
        this.descriptor = descriptor;
    }

    public PtId getUli() {
        return uli;
    }

    public void setUli(PtId uli) {
        this.uli = uli;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}