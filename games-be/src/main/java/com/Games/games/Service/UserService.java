package com.Games.games.Service;

import com.Games.games.DTO.UserDTO;
import com.Games.games.Entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    UserDTO getUserByEmail(String email);
}
