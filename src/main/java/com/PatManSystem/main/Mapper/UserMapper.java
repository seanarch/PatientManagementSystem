package com.PatManSystem.main.Mapper;

import com.PatManSystem.main.DTO.UserDTO;
import com.PatManSystem.main.Models.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserDTO(UserDTO userDTO, @MappingTarget User user);
}
