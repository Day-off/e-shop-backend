package com.example.iti0302backend.controllers;

import com.example.iti0302backend.dto.UserDto;
import com.example.iti0302backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/api/public/register")
    public void registerNewEmployee(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @PostMapping("/api/public/login")
    public String loginUser(@RequestBody UserDto userDto) {
        return userService.login(userDto.getEmail(), userDto.getPassword());
    }

    @GetMapping("/api/user")
    public UserDto getUserById(int id){
        return userService.getUserById(id);
    }

}
