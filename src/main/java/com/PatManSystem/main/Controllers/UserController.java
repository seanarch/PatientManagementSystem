package com.PatManSystem.main.Controllers;

import com.PatManSystem.main.DTO.UserDTO;
import com.PatManSystem.main.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<UserDTO> getUser() {return userService.getUsers();
    }

    @GetMapping(path ="/id={id}")
    public UserDTO getUser(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }

    @PostMapping(path = "/new")
    public String registerNewUser(@RequestBody UserDTO userDTO){

        userService.newUser(userDTO);
        return "NEW: User identified by ID "+userDTO.getId()+" successfully added.";
    }

    @DeleteMapping(path = "/delete/id={id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "DELETE: User identified by ID "+id+" successfully deleted.";
    }

    @PostMapping(path = "/update")//UPDATE using post, take in DTO, null fields are NO CHANGE, and not-null is CHANGE, not including id
    public String updateUser(@RequestBody UserDTO userDTO){

        userService.updateUser(userDTO);
        return "UPDATE: User identified by ID "+userDTO.getId()+" successfully updated.";

    }
    @PutMapping(path = "update/id={id}") //UPDATE using PUT, take in params from address, absent params are NO CHANGE, and present params are CHANGE, not including id
    public String updateUser(
            @PathVariable("id") String id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String password
    ){
        userService.updateUser(new UserDTO(id,firstname,lastname,password));

        return "UPDATE: User identified by ID "+id+" successfully updated.";
    }

}