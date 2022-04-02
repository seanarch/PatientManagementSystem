package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.UserDTO;
import com.PatManSystem.main.Services.LoginService;
import com.PatManSystem.main.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin("*")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping(path = "/login")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public boolean loginUser(@RequestBody UserDTO userDTO){
        return loginService.loginUser(userDTO);
    }
}
