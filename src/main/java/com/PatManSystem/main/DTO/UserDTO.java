package com.PatManSystem.main.DTO;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private String id;
    private String firstname;
    private String lastname;
    private String password;
    private Boolean admin;

    public UserDTO(String id, String firstname, String lastname, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }
}
