package com.Games.games.Service.impl;

import com.Games.games.DTO.UserDTO;
import com.Games.games.Entity.User;
import com.Games.games.Mapper.UserMapper;
import com.Games.games.Repository.UserRepository;
import com.Games.games.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        Iterable<User> usuariosIterable = userRepository.findAll();
        List<User> users = new ArrayList<>();
        usuariosIterable.forEach(users::add);

        return users.stream().map(UserMapper::toDTO).toList();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User newUser = userRepository.save(user);

        return UserMapper.toDTO(newUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> usuarioExistenteOptional = userRepository.findById(id);
        if (usuarioExistenteOptional.isPresent()) {
            User user = usuarioExistenteOptional.get();
            user.setNombre(userDTO.getNombre());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            User updatedUser = userRepository.save(user);

            return UserMapper.toDTO(updatedUser);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);

        return UserMapper.toDTO(user);
    }
}