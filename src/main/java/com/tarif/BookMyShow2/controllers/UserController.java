package com.tarif.BookMyShow2.controllers;

import com.tarif.BookMyShow2.dtos.*;
import com.tarif.BookMyShow2.dtos.ResponseStatus;
import com.tarif.BookMyShow2.models.User;
import com.tarif.BookMyShow2.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    /*
    CRUD --> Create, Read, Update, Delete
     */
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        UserResponseDTO response = new UserResponseDTO();
        response.setUser(user);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

    @PostMapping("/signup")
    public SignupUserResponseDTO signUp(@RequestBody SignupUserRequestDTO request) {
        User user = userService.signUp(request.getEmail(), request.getPassword(), request.getName());
        SignupUserResponseDTO response = new SignupUserResponseDTO();
        response.setUser(user);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

}
