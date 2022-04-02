package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.UserDTO;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SneakyThrows
    public boolean loginUser(UserDTO DTO) {
        return userRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("User not found.")).getPassword().equals(DTO.getPassword());
    }
}