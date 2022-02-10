package com.PatManSystem.main.Models;

/**
 *
 * @author Connor
 */
public class Patient {
    
    private long ULI; //Unique Lifetime Identifier or Alberta Health Number PHN (Personal Health Number)
    private String Lastname;
    private String Firstname;

    public Patient(long ULI, String Lastname, String Firstname) {
        this.ULI = ULI;
        this.Lastname = Lastname;
        this.Firstname = Firstname;
    }

    
    
    public long getULI() {
        return ULI;
    }

    public void setULI(long ULI) {
        this.ULI = ULI;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }
    
    
    
}
