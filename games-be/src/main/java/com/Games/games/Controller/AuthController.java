package com.Games.games.Controller;

import com.Games.games.DTO.UserDTO;
import com.Games.games.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AuthController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {
        UserDTO existingUserDTO = userServiceImpl.getUserByEmail(userDTO.getEmail());
        if (existingUserDTO != null && existingUserDTO.getPassword().equals(userDTO.getPassword())) {

            return new ResponseEntity<>(existingUserDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO = userServiceImpl.createUser(userDTO);

        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }
}
