package com.Games.games.Mapper;

import com.Games.games.DTO.UserDTO;
import com.Games.games.Entity.User;

public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setIdUsuario(userDTO.getId());
        user.setNombre(userDTO.getNombre());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getIdUsuario());
        userDTO.setNombre(user.getNombre());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
