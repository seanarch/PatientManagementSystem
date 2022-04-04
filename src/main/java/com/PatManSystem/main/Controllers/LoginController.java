package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.UserDTO;
import com.PatManSystem.main.Services.LoginService;
import com.PatManSystem.main.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/login" ,
        method = {RequestMethod.POST})
@CrossOrigin("http://localhost:3000")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping //perform a login in attempt, return TRUE if the username and password are correct, FALSE otherwise
    public boolean loginUser(@RequestBody UserDTO userDTO){
        return loginService.loginUser(userDTO);
    }
}
