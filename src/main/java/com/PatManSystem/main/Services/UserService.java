package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.UserDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.UserMapperImpl;
import com.PatManSystem.main.Models.User;
import com.PatManSystem.main.Repository.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers(){
       List <UserDTO> userList = userRepository.findAll()
                .stream()
                .map(new UserMapperImpl()::userToUserDTO)
                .collect(Collectors.toList());

        for (UserDTO userDTO : userList) {
            userDTO.setPassword(null);
        }
        return userList;
    }

    @SneakyThrows
    public UserDTO getUser(Integer id){
        return new UserMapperImpl()
                .userToUserDTO(userRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("User identified by id:{"+id+"} was not found.")));
    }

    @SneakyThrows
    public void newUser(UserDTO DTO){

        if(userRepository.findById(DTO.getId()).isPresent())
            throw new DuplicateFoundException("Raditationtherapy identified by ID:{"+DTO.getId()+"} already exists.");

        userRepository.save(new UserMapperImpl().userDTOToUser(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteUser(Integer id){

        userRepository.findById(id).orElseThrow(() -> new NotFoundException("User identified by ID:{"+id+"} was not found."));
        userRepository.deleteById(id);

    }

   @SneakyThrows
    public void updateUser(UserDTO DTO){

        User setEntity = userRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("User identified by ID:{"+DTO.getId()+"} was not found."));

        if (DTO.getFirstname() != null)
            setEntity.setFirstname(DTO.getFirstname());

        if (DTO.getLastname() != null)
            setEntity.setLastname(DTO.getLastname());

        if (DTO.getPassword() != null)
            setEntity.setPassword(DTO.getPassword());

        if (DTO.getFirstname() != null)
            setEntity.setFirstname(DTO.getFirstname());



        userRepository.save(setEntity);

    }
}